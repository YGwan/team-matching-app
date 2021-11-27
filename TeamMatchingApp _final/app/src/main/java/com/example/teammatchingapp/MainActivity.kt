package com.example.teammatchingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.auth.IntroActivity
import com.example.teammatchingapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


    class   MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //setContentView(R.layout.activity_main)
            binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)

    }
}