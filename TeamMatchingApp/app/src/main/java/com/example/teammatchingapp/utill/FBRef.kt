package com.example.teammatchingapp.utill

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FBRef {

    companion object{

        private val database = Firebase.database

        val boardref = database.getReference("board")

        val commentRef = database.getReference("comment")
    }
}