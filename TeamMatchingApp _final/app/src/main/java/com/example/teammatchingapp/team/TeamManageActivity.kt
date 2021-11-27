package com.example.teammatchingapp.team

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.teammatchingapp.R
import com.example.teammatchingapp.board.BoardActivity



class TeamManageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_manage)

        val navBoard = findViewById<TextView>(R.id.navBoard)
        navBoard.setOnClickListener {
            val intent = Intent(this,BoardActivity::class.java)
            startActivity(intent)
            }

        val appbar1 = findViewById<ImageView>(R.id.appbar1)
        appbar1.setOnClickListener {
            finish()
        }


    }
}
