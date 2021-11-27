package com.example.teammatchingapp.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.R
import com.example.teammatchingapp.comment.CommentLVAdapter
import com.example.teammatchingapp.comment.CommentModel
import com.example.teammatchingapp.databinding.ActivityTeamBoardInsideBinding
import com.example.teammatchingapp.utill.FBAuth
import com.example.teammatchingapp.utill.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.lang.Exception

class TeamBoardInsideActivity : AppCompatActivity() {

    private val TAG = TeamBoardInsideActivity::class.java.simpleName

    private lateinit var binding: ActivityTeamBoardInsideBinding

    private lateinit var key : String

    private val commentDataList = mutableListOf<CommentModel>()

    private lateinit var commentAdapter : CommentLVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_team_board_inside)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_board_inside)

//        //1번 방법 - 데이터 받아오기
//
//       val title = intent.getStringExtra("title").toString()
//       val content = intent.getStringExtra("content").toString()
//       val time = intent.getStringExtra("time").toString()
//
//        binding.titleArea.text = title
//        binding.contentArea.text = content
//        binding.timeArea.text = time

        //2번째 방법

        //board key값 받아오기
        key = intent.getStringExtra("key").toString()
        getBoardData(key)
        binding.boardDelteIcon.setOnClickListener{
            showDialog()
        }

        //댓글 쓰기 버튼을 누르면 key값을 함수에 전달함.

        binding.commentBtn.setOnClickListener {
            insertComment(key)
        }

        getCommentData(key)

        commentAdapter = CommentLVAdapter(commentDataList)
        binding.commentLV.adapter = commentAdapter



    }

    //댓글과 관련된 값 가져오기
    fun getCommentData(key : String){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI

                commentDataList.clear()

                for (dataModel in dataSnapshot.children) {

                    val item = dataModel.getValue(CommentModel::class.java)
                    commentDataList.add(item!!)

                }

                commentAdapter.notifyDataSetChanged()



            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.d(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        FBRef.commentRef.child(key).addValueEventListener(postListener)

    }


    //댓글 저장 기능 구현 함수
   fun insertComment(key: String){
        //comment
            //boardKey
                //commentkey
                    //txt
                    //time
                    //uid

       FBRef.commentRef
           .child(key)
           .push()
           .setValue(
               CommentModel(binding.commentTxtArea.text.toString(),
               FBAuth.getTime(),
               FBAuth.getUid()
               )
           )

        Toast.makeText(this,"댓글 입력 완료",Toast.LENGTH_SHORT).show()
        binding.commentTxtArea.setText("")
    }





    //삭제 버튼 눌렀을때 삭제하기 dialog창 만들기

    private fun showDialog(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.delete_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("삭제하시겠습니까?")

        val alertDialog = mBuilder.show()
        alertDialog.findViewById<Button>(R.id.yesBtn)?.setOnClickListener{
            FBRef.boardref.child(key).removeValue()
            Toast.makeText(this,"삭제완료",Toast.LENGTH_LONG).show()
            finish()
        }

        alertDialog.findViewById<Button>(R.id.noBtn)?.setOnClickListener{
            finish()
        }

    }


    //board data 받아오기

    private fun getBoardData(key: String) {

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI

                //예외 처리문: 데이터가 삭제되고 난 후 key값이 없지만 데이터 변경으로 처리해 onDataChange가 실행되게되고
                //이로인해 문제가 발생해 사용

                try{
                    //key안 데이터는 한 덩어리이다. 따라서 반복문을 쓸 필요가 없다
                    //dataSnapshot에 board형태로 데이터를 가져옴
                    val dataModel = dataSnapshot.getValue(Board::class.java)

                    //각각의 데이터 값 가져오기
                    binding.titleArea.text = dataModel!!.title
                    binding.contentArea.text = dataModel!!.content
                    binding.timeArea.text = dataModel!!.time
                    dataModel.uid //게시판 글쓴이 uid

                    val myuid = FBAuth.getUid()
                    val writeruid = dataModel.uid //게시판 글쓴이 uid

                    if(myuid.equals(writeruid)){
                        Toast.makeText(baseContext,"삭제가 가능합니다",Toast.LENGTH_SHORT).show()
                        binding.boardDelteIcon.isVisible = true
                    }



                }catch (e: Exception){
                    Log.d(TAG,"삭제 완료")
                }



            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.boardref.child(key).addValueEventListener(postListener) // key값 안에 데이터 접근
    }

}

