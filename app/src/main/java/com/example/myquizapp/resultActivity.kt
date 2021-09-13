package com.example.myquizapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val userName = intent.getStringExtra(Contants.USER)
        val correct = intent.getIntExtra(Contants.CORRECT_ANSWER, 0)
        val total = intent.getIntExtra(Contants.TOTAL_QUESTIONS, 0)
        tv_userName.text = userName
        final_result.text = "$correct/$total"
        result_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}