package com.example.teammatchingapp.team


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.teammatchingapp.R
import com.example.teammatchingapp.utill.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class TeamConfirmActivity : AppCompatActivity() {

    private val teamListData = mutableListOf<teamModel >()
    private lateinit var teamLVadapter : teamListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_confirm)

        val appbar1 = findViewById<ImageView>(R.id.appbar1)
        appbar1.setOnClickListener {
            finish()
        }



        val teamListView = findViewById<ListView>(R.id.teamListView)

        teamLVadapter = teamListLVAdapter(teamListData)

        teamListView.adapter = teamLVadapter

        teamListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
               showDialog()
            }



        getTeamData()

    }

    fun getTeamData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI


                teamListData.clear()
                for (dataModel in dataSnapshot.children) {

                    val item = dataModel.getValue(teamModel::class.java)
                    teamListData.add(item!!)

                }

                teamLVadapter.notifyDataSetChanged()
                teamListData.reverse()


            }


            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message

            }
        }
        FBRef.teamRef.addValueEventListener(postListener)

    }

    private fun showDialog(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.delete_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("가입신청을 하시겠습니까? ")

        val alertDialog = mBuilder.show()
        alertDialog.findViewById<Button>(R.id.yesBtn)?.setOnClickListener{
            Toast.makeText(this,"가입 신청이 완료되었습니다.", Toast.LENGTH_LONG).show()
            finish()
        }

        alertDialog.findViewById<Button>(R.id.noBtn)?.setOnClickListener{
            Toast.makeText(this,"가입 신청을 취소하였습니다", Toast.LENGTH_LONG).show()
            finish()
        }

    }
}