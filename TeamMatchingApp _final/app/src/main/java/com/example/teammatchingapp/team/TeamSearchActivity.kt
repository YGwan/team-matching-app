package com.example.teammatchingapp.team

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.teammatchingapp.R
import com.example.teammatchingapp.manager.TeamFragment

class TeamSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_search)

        val appbar1 = findViewById<ImageView>(R.id.appbar1)
        appbar1.setOnClickListener {
            finish()
        }

        // 현재 개설된 팀 목록 키워드로 입력 받아 검색
        val team_search_bar = findViewById<EditText>(R.id.teamSearchBar)

        val teamSIcon = findViewById<LinearLayout>(R.id.teamSearchIcon)
        teamSIcon.setOnClickListener{
            val searchKeyword = team_search_bar.text.toString()
            // TODO: 입력 결과 데이터베이스에서 query
        }

    }
}