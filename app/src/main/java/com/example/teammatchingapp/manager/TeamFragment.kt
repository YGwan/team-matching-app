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
import com.example.teammatchingapp.databinding.FragmentTeamBinding
import com.example.teammatchingapp.team.TeamConfirmActivity
import com.example.teammatchingapp.team.TeamCreateActivity
import com.example.teammatchingapp.team.TeamManageActivity
import com.example.teammatchingapp.team.TeamSearchActivity

class TeamFragment : Fragment() {

    private lateinit var binding: FragmentTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_team, container, false)

                                    //쓰는 페이지로 이동 부분


                                                //페이지 이동 부분

        //홈으로 이동
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_teamFragment_to_homeFragment)
        }

        //설정으로 이동
        binding.settingTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_teamFragment_to_settingFragment)
        }

        //팀만들기로 이동
        binding.teamMakeBtn.setOnClickListener {
            val intent = Intent(context, TeamCreateActivity::class.java)
            startActivity(intent)
        }

        //팀 생성 페이지로 이동
        binding.teamSearchBtn.setOnClickListener {
            val intent = Intent(context, TeamSearchActivity::class.java)
            startActivity(intent)
        }

        //팀 관리 페이지로 이동
        binding.navTeamManager.setOnClickListener {
            val intent = Intent(context, TeamManageActivity::class.java)
            startActivity(intent)
        }

        //팀 가입확인 페이지로 이동
        binding.confirmedBtn.setOnClickListener {
            val intent = Intent(context, TeamConfirmActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


}
