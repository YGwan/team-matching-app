package com.example.teammatchingapp.manager

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.teammatchingapp.R
import com.example.teammatchingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

                                                    //페이지 이동 부분

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.homeTap

        binding.teamTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_teamFragment)
        }

        binding.settingTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
        }

        //공모전 버튼을 눌렀을때, 사이트로 이동하는 코드

        binding.sinGoodArea.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thinkcontest.com"))
            startActivity(intent)
        }

        binding.singYouArea.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://thinkyou.co.kr"))
            startActivity(intent)
        }

        binding.youngArea.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://allforyoung.com"))
            startActivity(intent)
        }

        binding.pickArea.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.campuspick.com"))
            startActivity(intent)
        }

        binding.recomImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://intiin.com/sub01/sub01_04.html?ptype=view&idx=5415&page=1&code=notice"))
            startActivity(intent)
        }

        return binding.root
    }



}