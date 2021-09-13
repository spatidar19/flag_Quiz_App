package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_Start = findViewById<Button>(R.id.btn_Start)
        val et_name = findViewById<TextView>(R.id.et_name)
        btn_Start.setOnClickListener {
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, quizQuestions::class.java)
                intent.putExtra(Contants.USER, et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}