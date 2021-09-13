package com.example.myquizapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class quizQuestions : AppCompatActivity(), View.OnClickListener{

    var mCurrentCount: Int = 1
    var mCorrectAnswer: Int = 0
    var mQuestionList: ArrayList<questions>? = null
    var mSelectedOption: Int = 0
    var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUserName = intent.getStringExtra(Contants.USER)
        setContentView(R.layout.activity_quiz_questions)
        mQuestionList = Contants.getQuestions()
        setQuestion()
        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }
    fun setQuestion(){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val optionOne = findViewById<TextView>(R.id.optionOne)
        val optionTwo = findViewById<TextView>(R.id.optionTwo)
        val optionThree = findViewById<TextView>(R.id.optionThree)
        val optionFour = findViewById<TextView>(R.id.optionFour)
        val progress = findViewById<TextView>(R.id.progress)
        setDefaultOptions()
        if(mCurrentCount == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
        val question = mQuestionList!![mCurrentCount - 1]
        progressBar.progress = mCurrentCount
        progress.text = "$mCurrentCount" + "/" + "${progressBar.max}"
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
    }
    private fun setDefaultOptions(){
        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)
        for(option in options){
            option.setTextColor(Color.parseColor("#34495E"))
            option.background = ContextCompat.getDrawable(this, R.drawable.bg_for_options)
            option.typeface = Typeface.DEFAULT
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.optionOne ->{
                selectedOptionView(optionOne, 1)
            }
            R.id.optionTwo ->{
                selectedOptionView(optionTwo, 2)
            }
            R.id.optionThree ->{
                selectedOptionView(optionThree, 3)
            }
            R.id.optionFour ->{
                selectedOptionView(optionFour, 4)
            }
            R.id.btn_submit ->{
                if(mSelectedOption == 0){
                    mCurrentCount++

                    when{
                        mCurrentCount <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, resultActivity::class.java)
                            intent.putExtra(Contants.USER, mUserName)
                            intent.putExtra(Contants.CORRECT_ANSWER, mCorrectAnswer)
                            intent.putExtra(Contants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)

                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentCount-1)
                    if(question!!.correctAnswer != mSelectedOption){
                        correctAnswer(mSelectedOption, R.drawable.wrong_answer_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    correctAnswer(question.correctAnswer, R.drawable.correct_answer_bg)
                    if (mCurrentCount == mQuestionList?.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "Go to next question"
                    }
                    mSelectedOption = 0
                }
            }
        }

    }
    private fun selectedOptionView(tv: TextView, selectedOption: Int){
        setDefaultOptions()
        mSelectedOption = selectedOption
        tv.setTextColor(Color.parseColor("#2C3E50"))
        tv.background = ContextCompat.getDrawable(this, R.drawable.bg_for_options_selected)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }
    private fun correctAnswer(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                optionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 ->{
                optionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 ->{
                optionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 ->{
                optionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}