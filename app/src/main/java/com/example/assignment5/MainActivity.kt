package com.example.assignment5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var author : EditText
    lateinit var year : EditText

    lateinit var insert : Button
    lateinit var view : Button

    var DB =  BookDbHelper(this)


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        author = findViewById(R.id.author)
        year = findViewById(R.id.year)
        insert = findViewById(R.id.BtnInsert)
        view = findViewById(R.id.BtnView)





    }

    fun viewData(view: View) {
        if (view is Button) {
            val intent = Intent(this, Data::class.java)

            startActivity(intent)

        }
    }
    fun insertData(view: View){
        if (view is Button) {
            val nameText = name.text.toString()
            val authorText = author.text.toString()
            val year = year.text.toString()


            DB.insert(authorText, nameText, year.toInt())

        }
    }
}


