 package com.example.teammatchingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.teammatchingapp.auth.IntroActivity


 class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //2초뒤에 다음 화면으로 IntroActivity화면이 나오게함
        Handler().postDelayed({
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        },2000)
    }
}