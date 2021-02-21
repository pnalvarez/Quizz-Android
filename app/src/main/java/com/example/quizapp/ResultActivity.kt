package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private var mUsername: String? = null
    private var mCorrectAnswers: Int = 0
    private var mTotalQuestions: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        mUsername = intent.getStringExtra(Constants.USER_NAME)
        mCorrectAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        mTotalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        setupUI()
    }

    private fun setupUI() {
        tv_username.text = mUsername
        tv_score.text = "Your score is " + "${mCorrectAnswers} " + "of " + "${mTotalQuestions}"
        btn_finish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
