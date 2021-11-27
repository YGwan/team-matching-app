package com.example.teammatchingapp.team

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.teammatchingapp.R
import com.example.teammatchingapp.manager.TeamFragment

class TeamConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_confirm)

        val appbar1 = findViewById<ImageView>(R.id.appbar1)
        appbar1.setOnClickListener {
            finish()
        }
    }
}