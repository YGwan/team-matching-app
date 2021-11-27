package com.example.teammatchingapp.utill

import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*


class FBAuth {

    companion object {

        private lateinit var auth: FirebaseAuth


        //uid 값

        fun getUid(): String {
            auth = FirebaseAuth.getInstance()
            return auth.currentUser?.uid.toString()
        }

        //아이디 값

        fun getEmail(): String {
            return auth.currentUser?.email.toString()
        }

        //현재 시간
        fun getTime(): String {

            val currentDataTime = Calendar.getInstance().time
            val dataFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDataTime)
            return dataFormat
        }

        //생성일

        fun getDate(): String {
            val currentDataTime = Calendar.getInstance().time
            val dataFormat = SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(currentDataTime)
            return dataFormat
        }


    }

}
