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
import com.example.teammatchingapp.board.BoardActivity
import com.example.teammatchingapp.databinding.FragmentTeamBinding

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

        binding.boardBtn.setOnClickListener {
            val intent  = Intent(context, BoardActivity::class.java)
            startActivity(intent)
        }

                                                //페이지 이동 부분

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_teamFragment_to_homeFragment)
        }


        binding.settingTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_teamFragment_to_settingFragment)
        }

        return binding.root
    }


}
