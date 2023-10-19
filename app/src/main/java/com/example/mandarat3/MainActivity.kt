package com.example.mandarat3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var inputTextView: EditText
    private lateinit var goalEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.next)
        inputTextView = findViewById(R.id.inputTextView)
        goalEditText = findViewById(R.id.editTextTextPersonName2)


        nextButton.setOnClickListener {
            // EditText에서 사용자 입력값을 가져옴
            val mandaratTitle = inputTextView.text.toString()
            val userGoal = goalEditText.text.toString()

            // 사용자가 값을 입력하지 않았을 경우 경고 다이얼로그 표시
            if (mandaratTitle.isEmpty() || userGoal.isEmpty()) {
                showEmptyInputWarningDialog()
            } else {
                // 다음 화면으로 데이터를 전달하기 위한 Intent 생성
                val intent = Intent(this, Mandarat::class.java)

                // Intent에 데이터 추가
                intent.putExtra("MANDARAT_TITLE", mandaratTitle)
                intent.putExtra("USER_GOAL", userGoal)

                // MandaratActivity로 이동
                startActivity(intent)
            }
        }
    }

    private fun showEmptyInputWarningDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("값을 입력해주세요.")
        builder.setPositiveButton("확인", null)
        val dialog = builder.create()
        dialog.show()
    }
}
