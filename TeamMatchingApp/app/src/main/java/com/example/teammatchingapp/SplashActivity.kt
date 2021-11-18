 package com.example.teammatchingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.teammatchingapp.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


 class SplashActivity : AppCompatActivity() {

     private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        if(auth.currentUser?.uid == null) {
            //로그인이 안돼으면 2초뒤에 다음 화면으로 Intro페이지로 이동시킴
            Handler().postDelayed({
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            },2000)

        }

        else{
            //로그인이 되어있으면 바로 main페이지로 이동시킴
            Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            },2000)
        }

    }
 }