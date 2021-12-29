package com.nadia.counterapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var counterTextView: TextView
    lateinit var totalTextView: TextView
    private var counter = 0
    private val colors: Array<String> = arrayOf(
        "#F37F7F",
        "#94D3A5",
        "#856CCA",
        "#FF5722",
        "#CDDC39",
        "#009688",
        "#4CAF50",
        "#615F5F",
        "#DBF3B6",
        "#BFFFE9")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.tv_counter)
        totalTextView = findViewById(R.id.tv_total_counts)

        val resetButton = findViewById<Button>(R.id.btn_reset)
        val layout = findViewById<ConstraintLayout>(R.id.layout)

        layout.setOnClickListener {
            increaseCounterChangeColor()
        }

        resetButton.setOnClickListener {
            counter = 0
            counterTextView.text = counter.toString()
            counterTextView.setTextColor(Color.BLACK)
            Toast.makeText(this , "Setting count to zero " , Toast.LENGTH_LONG ).show()
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

    private fun getRandomColor(): Int {
        return Color.parseColor(colors[Random.nextInt(colors.size)])
    }

    private fun increaseCounterChangeColor() {
        counterTextView.text = counter.toString()
        counter++
        counterTextView.text = counter.toString()
        if (counter % 10 == 0) {
            counterTextView.setTextColor(getRandomColor())
        }
    }
}