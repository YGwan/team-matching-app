package com.example.teammatchingapp.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.teammatchingapp.R



class TeamCreatLVAdapter(val teamList : MutableList<TeamModel>) : BaseAdapter() {

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

        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.team_create_item, parent, false)
        }

        val title = view?.findViewById<TextView>(R.id.teamCreateName)
        val purpose = view?.findViewById<TextView>(R.id.teamCreatePurpose)
        val Date = view?.findViewById<TextView>(R.id.teamCreateDate)

        title!!.text = teamList[position].teamName
        purpose!!.text = teamList[position].teamPurpose
        Date!!.text = teamList[position].teamDate

        return view!!
    }

}