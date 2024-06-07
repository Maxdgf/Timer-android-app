package com.example.timer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.os.CountDownTimer


lateinit var buttonStart: Button
lateinit var timer: TextView
lateinit var input1: EditText
lateinit var input2: EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer = findViewById(R.id.timer)
        buttonStart = findViewById(R.id.btn_start)
        input1 = findViewById(R.id.inputSeconds)
        input2 = findViewById(R.id.inputInterval)




        buttonStart.setOnClickListener {
            object : CountDownTimer(input1.text.toString().toLong(), input2.text.toString().toLong()) {

                override fun onTick(time: Long) {
                    timer.setText("" + time / input2.text.toString().toLong())
                }

                override fun onFinish() {
                    timer.setText("0")
                }
            }.start()
        }

    }
}
