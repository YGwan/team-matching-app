package com.example.teammatchingapp.team

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.example.teammatchingapp.R
import com.example.teammatchingapp.auth.LoginActivity

class teamListLVAdapter(val teamList: MutableList<teamModel> ) : BaseAdapter() {

    override fun getCount(): Int {
        return teamList.size
    }

    override fun getItem(position: Int): Any {
        return teamList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if(view == null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.team_create_item,parent,false)
        }

        val name = view?.findViewById<TextView>(R.id.teamNameArea)
        val purpose = view?.findViewById<TextView>(R.id.teamPurposeArea)
        val leaderName = view?.findViewById<TextView>(R.id.teamLNArea)
        val date = view?.findViewById<TextView>(R.id.teamCreateDateArea)


        name!!.text = teamList[position].name
        purpose!!.text = teamList[position].purpose
        leaderName!!.text = teamList[position].teamleader
        date!!.text = teamList[position].date


        return view!!
    }



}
