package com.example.teammatchingapp.team

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.teammatchingapp.R
import com.example.teammatchingapp.board.BoardActivity
import com.example.teammatchingapp.utill.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class TeamManageActivity : AppCompatActivity() {

    private lateinit var teamCreateRVAdapter: TeamCreatLVAdapter

    private val teamCreateList = mutableListOf<TeamModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_manage)

        val navBoard = findViewById<TextView>(R.id.navBoard)
        navBoard.setOnClickListener {
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent)
        }


        teamCreateRVAdapter = TeamCreatLVAdapter(teamCreateList)

        val teamCreateListView = findViewById<ListView>(R.id.teamCreatListView)
        teamCreateListView.adapter = teamCreateRVAdapter

        teamCreateListView.setOnItemClickListener { parent, view, position, id ->


            val appbar1 = findViewById<ImageView>(R.id.appbar1)

            appbar1.setOnClickListener {
                finish()
            }
        }
        getFBTeamCreateData()
    }

    private fun getFBTeamCreateData() {

        val postListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI

                teamCreateList.clear() //파이어베이스의 데이터 중첩을 막기 위해 사용

                for (dataModel in dataSnapshot.children) {


                    //dataModel.key -> key값 가져오기



                    val item = dataModel.getValue(TeamModel::class.java)
                    teamCreateList.add(item!!)


                }

                //최신 게시물을 젤 위로 올리기(최신 게시물은 기본적으로 아래에 가게 되있다.)
                teamCreateList.reverse()

                // 다 만들고 이 함수가 실행되므로 그때 다시 만들어줘야되서 동기화시킴
                teamCreateRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        }
        FBRef.teamRef.addValueEventListener(postListener)
    }
}
