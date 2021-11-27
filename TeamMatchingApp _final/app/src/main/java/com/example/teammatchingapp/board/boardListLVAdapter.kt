package com.example.teammatchingapp.board

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.teammatchingapp.R
import com.example.teammatchingapp.utill.FBAuth


//팀_게시판 정보를 담는 어뎁터 구현 코드

class boardListLVAdapter(val boardList : MutableList<Board>) : BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        //if(view == null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.team_board_list_item, parent,false)
        //}


        val itemLinearLayoutView = view?.findViewById<LinearLayout>(R.id.itemLinearLayout)
        val title = view?.findViewById<TextView>(R.id.tbTextArea)
        val content = view!!.findViewById<TextView>(R.id.tbContentArea)
        val time = view!!.findViewById<TextView>(R.id.tbTimeArea)

        if(boardList[position].uid.equals(FBAuth.getUid())){
            itemLinearLayoutView?.setBackgroundColor((Color.parseColor("#ffd08c")))
        }

        title!!. text = boardList[position].title
        content!!.text  = boardList[position].content
        time!!.text  = boardList[position].time

        return view!!

    }


}