package com.example.batikpedia.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager.widget.ViewPager
import com.example.batikpedia.R
import com.example.batikpedia.databinding.ActivityMainBinding
import com.example.batikpedia.ui.detection.DetectionActivity
import com.google.android.material.tabs.TabLayout
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewPager :ViewPager
    private lateinit var imageList: List<String>
    private lateinit var tabLayout:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewPager=binding.viewPager
        tabLayout=binding.tabs

        tabLayout.setupWithViewPager(viewPager)

        imageList= listOf(
            "https://cdn-2.tstatic.net/jogja/foto/bank/images/batik.jpg",
            "https://cdn-2.tstatic.net/jogja/foto/bank/images/batik.jpg",
            "https://cdn-2.tstatic.net/jogja/foto/bank/images/batik.jpg",
            "https://cdn-2.tstatic.net/jogja/foto/bank/images/batik.jpg",
        )

        viewPager.adapter=CarouselAdapter(this,imageList)

        autoImageSlide()



        binding.fabDetect.setOnClickListener {
            //intent to detection activity
            val intent = Intent(this, DetectionActivity::class.java)
            startActivity(intent)
        }

    }

    private fun autoImageSlide() {
        val handler = android.os.Handler()
        val runnable = Runnable {
            var i = viewPager.currentItem
            i = if (i == imageList.size - 1) 0 else ++i
            viewPager.setCurrentItem(i, true)
        }

        val swipeTimer = java.util.Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(runnable)
            }
        }, 3000, 3000)
    }
}