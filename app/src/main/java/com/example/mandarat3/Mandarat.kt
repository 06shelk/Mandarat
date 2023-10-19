package com.example.mandarat3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class Mandarat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mandarat)

        // Intent에서 "MANDARAT_TITLE"과 "USER_GOAL" 키로 전달된 값을 가져옵니다.
        val mandaratTitle = intent.getStringExtra("MANDARAT_TITLE")
        val userGoal = intent.getStringExtra("USER_GOAL")

        // 가져온 값을 각각의 TextView에 설정합니다.
        val mTitleTextView = findViewById<TextView>(R.id.mTitle)
        val cell5TextView = findViewById<TextView>(R.id.cell5)

        mTitleTextView.text = mandaratTitle
        cell5TextView.text = userGoal
    }
}
