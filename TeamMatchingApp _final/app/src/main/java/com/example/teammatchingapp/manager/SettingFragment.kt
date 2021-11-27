package com.example.teammatchingapp.manager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.teammatchingapp.R
import com.example.teammatchingapp.auth.IntroActivity
import com.example.teammatchingapp.databinding.FragmentSettingBinding
import com.example.teammatchingapp.utill.FBAuth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SettingFragment : Fragment() {

    private lateinit var binding : FragmentSettingBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_setting, container, false)

        auth = Firebase.auth

                                            //페이지 이동 부분

        binding.homeTap.setOnClickListener {

            it.findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
        }

        binding.teamTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_settingFragment_to_teamFragment)
        }


                                        //사용자 정보 가져오기

//        val user = Firebase.auth.currentUser
//
//        if (user != null) {
//            val user = Firebase.auth.currentUser
//            user?.let {
//                val email = user.email
//                // Check if user's email is verified
//                val emailVerified = user.isEmailVerified
//                val uid = user.uid
//
//                binding.settingIdArea.setText(email)
//                binding.settingUidArea.setText(uid)
//            }
//
//        } else {
//            // No user is signed in
//            Toast.makeText(context,"오류가 발생했습니다. 고객센터에 문의 바랍니다.", Toast.LENGTH_LONG).show()
//        }

        //위의 방법보다 더 쉽게 사용자 정보 가져오기

        val uid = FBAuth.getUid()
        binding.settingUidArea.setText(uid)

        val email = FBAuth.getEmail()
        binding.settingIdArea.setText(email)

                                    //로그아웃, 화면 이동 섹션 구현


        binding.logoutBtn.setOnClickListener{
            auth.signOut()

            val intent = Intent(context, IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        //강제 종료

        binding.closeBtn.setOnClickListener{
            System.exit(0)



        }

        ////////////////

        return binding.root
    }



}
