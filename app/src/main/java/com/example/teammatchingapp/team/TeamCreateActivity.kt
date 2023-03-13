package com.example.teammatchingapp.team

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.R
import com.example.teammatchingapp.databinding.ActivityTeamCreateBinding
import com.example.teammatchingapp.utill.FBAuth
import com.example.teammatchingapp.utill.FBRef

class TeamCreateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTeamCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_team_create)
        //setContentView(R.layout.activity_team_create)

        val appbar1 = findViewById<ImageView>(R.id.appbar1)
        binding.teamCreateDate.setText(FBAuth.getDate())

        appbar1.setOnClickListener {
            finish()
        }


        binding.teamCreateBtn.setOnClickListener {

            var isGoToSend = true //빈 값 감지 변수


            val title = binding.teamCreateName.text.toString()
            val purpose = binding.teamCreatePurpose.text.toString()
            val num = binding.teamCreateNum.text.toString()
            val date = binding.teamCreateDate.text.toString()
            val uid = FBAuth.getUid()


            //빈값이 있으면 실행 안함

            if (title.isBlank()) {
                Toast.makeText(this, "제목 부분을 작성하시오.", Toast.LENGTH_SHORT).show()
                isGoToSend = false
            }

            if (purpose.isBlank()) {
                Toast.makeText(this, "팀 목적 부분을 작성하시오.", Toast.LENGTH_SHORT).show()
                isGoToSend = false
            }

            if (num.isBlank()) {
                Toast.makeText(this, "팀 팀장 이름 부분을 작성하시오.", Toast.LENGTH_SHORT).show()
                isGoToSend = false
            }



            if (isGoToSend) {

//               team
//                -팀이름
//                  -팀 주제
//                     -팀 인원
//                        - 팀 활동 기간
//                            - uid

                FBRef.teamRef
                    .push()
                    .setValue(teamModel(title,purpose,num,date,uid))
                Toast.makeText(this, "팀 생성 완료", Toast.LENGTH_LONG).show()
                finish()
            }
        }


        binding.teamResetBtn.setOnClickListener{

            binding.teamCreateName.setText("")
            binding.teamCreatePurpose.setText("")
            binding.teamCreateNum.setText("")

        }
    }

}
