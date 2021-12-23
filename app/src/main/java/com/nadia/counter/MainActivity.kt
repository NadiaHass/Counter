package com.nadia.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nadia.counter.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var counter = 0
    private val colorsTxt: Array<String> = applicationContext.resources.getStringArray(R.array.colors)
    private val colors : MutableList<Int> ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layout.setOnClickListener {
            increaseCounterChangeColor(getRandomColor())
        }
        binding.ivReset.setOnClickListener {
            counter = 0
            binding.tvCounter.text = counter.toString()
            binding.tvCounter.setTextColor(Color.BLACK)

        }
    }

    private fun getRandomColor(): Int {
        for (i in 0..colorsTxt.size) {
            val newColor = Color.parseColor(colorsTxt[i])
            colors?.add(newColor)
        }
        return colors!![Random.nextInt(colors.size)]
    }

    private fun increaseCounterChangeColor(color : Int) {
        binding.tvCounter.text = counter.toString()
        counter++
        binding.tvCounter.text = counter.toString()
        if (counter%10 == 0){
            binding.tvCounter.setTextColor(color)
        }
    }

}