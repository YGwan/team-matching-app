package com.example.teammatchingapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.MainActivity
import com.example.teammatchingapp.R
import com.example.teammatchingapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_login)

        auth = Firebase.auth


        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.loginBtn.setOnClickListener {

            val email = binding.emailArea.text.toString()
            val pwd = binding.pwdArea.text.toString()


                                        //로그인 구현 코드

            auth.signInWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "로그인 성공",Toast.LENGTH_LONG).show()
                        val intentMain = Intent(this, MainActivity::class.java)

                        //메인 페이지 이동 후, 뒤로가기 버튼을 클릭하면 화면이 꺼짐
                        intentMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intentMain)


                        
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "로그인 실패",Toast.LENGTH_LONG).show()

                    }
                }


        }


    }


}