package com.example.teammatchingapp.board

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.teammatchingapp.R
import com.example.teammatchingapp.databinding.ActivityBoardWriteBinding
import com.example.teammatchingapp.databinding.FragmentTeamBinding
import com.example.teammatchingapp.utill.FBAuth
import com.example.teammatchingapp.utill.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_board_write)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_board_write)

        //입력 버튼 구현

        binding.writeContentBtn.setOnClickListener {


            var isGoToSend = true //빈 값 감지 변수

            val title = binding.boardTitleArea.text.toString()
            val content = binding.boardContentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            //빈값이 있으면 실행 안함

            if (title.isBlank() || content.isBlank()) {
                Toast.makeText(this, "빈 값이 없는지 확인하시오.", Toast.LENGTH_LONG).show()
                isGoToSend = false
            }



            if (isGoToSend) {
                //firebase data구조
                //board
                //  - key
                //      -boardModel(title, content, uid, time)
                FBRef.boardref
                    .push()
                    .setValue(Board(title, content, uid, time))

                Toast.makeText(this, "게시글 입력을 완료", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        //취소 버튼 구현

        binding.cancelBtn.setOnClickListener {

            finish()
        }

    }
}