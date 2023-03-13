package com.example.teammatchingapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.MainActivity
import com.example.teammatchingapp.R
import com.example.teammatchingapp.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding:ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_join)

        auth = Firebase.auth


        binding =  DataBindingUtil.setContentView(this,R.layout.activity_join)

                          //회원가입 버튼을 누르면 실행되는 코드

        binding.dojoinBtn.setOnClickListener {

                            //조건 변수 설정

            var isGoToJoin = true

                            //값 불러오기

            val email = binding.emailArea.text.toString()
            val pwd1 = binding.pwdArea1.text.toString()
            val pwd2 = binding.pwdArea2.text.toString()

                            // 빈 값 있는지 확인

            if(email.isBlank() || pwd1.isBlank() || pwd2.isBlank()){
                Toast.makeText(this,"빈 값이 없는지 확인하시오.",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

                            // 비밀번호가 서로 같은지 확인

           if(!pwd1.equals(pwd2)){
                Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_LONG).show()
               isGoToJoin = false
           }

                            // 비밀번호가 8글자 이상인지 확인

            if(pwd1.length < 8) {
                Toast.makeText(this,"비밀번호는 8자리이상 입력해야합니다.",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

                            // 모든 조건이 맞으면 회원 가입 진행


            if(isGoToJoin){

                             // 신규 사용자 가입 코드

                                 auth.createUserWithEmailAndPassword(email,pwd1)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(this,"회원가입 성공",Toast.LENGTH_LONG).show()

                            // 회원가입에 성공하면 메인페이지로 이동
                            val intentMain = Intent(this,MainActivity::class.java)

                            // 메인 페이지 이동 후, 뒤로가기 버튼을 클릭하면 화면이 꺼짐
                            intentMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intentMain)


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this,"회원가입 실패",Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}