package com.example.teammatchingapp.board

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.R
import com.example.teammatchingapp.databinding.ActivityBoardBinding
import com.example.teammatchingapp.utill.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class BoardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardBinding

    private val TAG = BoardActivity::class.java.simpleName

    private val boardKeyList = mutableListOf<String>()

    //동기화 작업

    private lateinit var teamBoardRVAdapter: boardListLVAdapter

    private val teamBoardList = mutableListOf<Board>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_board)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_board)


        //쓰는 페이지로 이동 부분

        binding.writeBtn.setOnClickListener {
            val intent  = Intent(this,BoardWriteActivity::class.java)
            startActivity(intent)
        }

        //뒤로기 가기 버튼 구현
        binding.backBtn.setOnClickListener {
            finish()
        }

        //리스트 뷰에 게시판 연결 구현 + 파이어베이스로 데이터를 가져와 adapter랑 연결

        teamBoardRVAdapter = boardListLVAdapter(teamBoardList)
        binding.teamBoardListView.adapter = teamBoardRVAdapter

        //각각의 리스트뷰 값을 입력하면 해당 페이지로 이동하는 작업 구현

        binding.teamBoardListView.setOnItemClickListener { parent, view, position, id ->

            //게시판의 title content time 값을 다음 페이지에서 받아오는 부분

//            //방법 1> listView에 있는 title, content, time 값을 다른 엑티비티로 전달해줘서 구현방법
//
//            val intent = Intent(this, TeamBoardInsideActivity::class.java)
//
//            intent.putExtra("title",teamBoardList[position].title)
//            intent.putExtra("content",teamBoardList[position].content)
//            intent.putExtra("time",teamBoardList[position].time)
//
//            startActivity(intent)


            //방법 2> firebase에 있는 board에 대한 id를 기반으로 데이터를 받아오는 방법

            val intent = Intent(this, TeamBoardInsideActivity::class.java)
            intent.putExtra("key",boardKeyList[position])
            startActivity(intent)
        }

       getFBTeamBoardData()
    }

    //파이어베이스에서 데이터를 받아오는 부분

    private fun getFBTeamBoardData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI

                teamBoardList.clear() //파이어베이스의 데이터 중첩을 막기 위해 사용

                for (dataModel in dataSnapshot.children) {
                    Log.d(TAG, dataModel.toString())

                    //dataModel.key -> key값 가져오기

                    val item = dataModel.getValue(Board::class.java)
                    teamBoardList.add(item!!)
                    boardKeyList.add(dataModel.key.toString())

                }

                //key값 또한 반대 순서부터 접근하므로 reverse 해줘야 된다.
                boardKeyList.reverse()

                //최신 게시물을 젤 위로 올리기(최신 게시물은 기본적으로 아래에 가게 되있다.)
                teamBoardList.reverse()

                // 다 만들고 이 함수가 실행되므로 그때 다시 만들어줘야되서 동기화시킴
                teamBoardRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.d(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardref.addValueEventListener(postListener)
    }

}