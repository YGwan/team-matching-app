package com.example.teammatchingapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.R
import com.example.teammatchingapp.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_intro)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

                         //로그인 가입창으로 이동 코드

        binding.loginBtn.setOnClickListener{
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

                        //회원가입창으로 이동 코드

        binding.joinBtn.setOnClickListener{
            intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
    }
}