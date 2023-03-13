package com.example.teammatchingapp.comment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.teammatchingapp.R
import com.example.teammatchingapp.utill.FBAuth

class CommentLVAdapter (val commentList : MutableList<CommentModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return commentList.size
    }

    override fun getItem(position: Int): Any {
        return commentList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if(view == null){
        view = LayoutInflater.from(parent?.context).inflate(R.layout.comment_list_item, parent,false)
        }

        val commentLinearLayoutView = view?.findViewById<LinearLayout>(R.id.commentLinearLayout)

        val title = view?.findViewById<TextView>(R.id.commentTitleArea)

        val time = view!!.findViewById<TextView>(R.id.commentTimeArea)

        //자기가 쓴 댓글이면 layout색을 갱신함
        if(commentList[position].uid.equals(FBAuth.getUid())){
            commentLinearLayoutView?.setBackgroundColor((Color.parseColor("#ff9d0d")))
        }


        title!!.text = commentList[position].commentTitle
        time!!.text  = commentList[position].commentCreatedTime


        return view!!
    }

}