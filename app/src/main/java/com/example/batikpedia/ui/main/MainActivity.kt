package com.example.batikpedia.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikpedia.R
import com.example.batikpedia.databinding.ActivityMainBinding
import com.example.batikpedia.ui.detection.DetectionActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.fabDetect.setOnClickListener {
            //intent to detection activity
            val intent = Intent(this, DetectionActivity::class.java)
            startActivity(intent)
        }

    }
}