package com.nadia.counterapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var counterTextView: TextView
    private lateinit var totalTextView: TextView
    private var counter = 0
    private val colors: Array<Int> = arrayOf(R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.tv_counter)
        totalTextView = findViewById(R.id.tv_total_counts)

        val resetButton = findViewById<Button>(R.id.btn_reset)
        val layout = findViewById<ConstraintLayout>(R.id.layout)

        layout.setOnClickListener {
            increaseCounterAndChangeColor()
        }

        resetButton.setOnClickListener {
            resetCounterAndColor()
        }
    }
    override fun onResume() {
        super.onResume()
        val sp = getSharedPreferences("mySharedPreference" , MODE_PRIVATE)
        totalTextView.text = sp.getString("total","")
    }
    override fun onPause() {
        super.onPause()
        val sp = getSharedPreferences("mySharedPreference" , MODE_PRIVATE)
        val edit = sp.edit()
        edit.putString("total", counterTextView.text.toString())
        edit.apply()
    }
    private fun resetCounterAndColor(){
        counter = 0
        counterTextView.text = counter.toString()
        counterTextView.setTextColor(Color.BLACK)
        Toast.makeText(this , "Setting count to zero " , Toast.LENGTH_LONG ).show()
    }
    private fun increaseCounterAndChangeColor() {
        counterTextView.text = counter.toString()
        counter++
        counterTextView.text = counter.toString()
        if (counter % 10 == 0) {
            counterTextView.setTextColor(getRandomColor())
        }
    }
    private fun getRandomColor(): Int {
        return colors[Random.nextInt(colors.size)]
    }
}