package com.example.circle

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.circle.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val metrics = windowManager.currentWindowMetrics

        //Legacy size that Display#getSize reports
        val bounds: Rect = metrics.bounds

        val circleLayoutParams = binding.layoutCircle.layoutParams

        //Checks if the display is vertical or horizontal
        if (bounds.width() > bounds.height()) {
            circleLayoutParams?.height = bounds.height()
            circleLayoutParams?.width = bounds.height()
            d("dim", "width ${bounds.width()}")
            d("dim", "height ${bounds.height()}")
        } else {
            circleLayoutParams?.height = bounds.width()
            circleLayoutParams?.width = bounds.width()
            d("dim", "width ${bounds.width()}")
            d("dim", "height ${bounds.height()}")
        }
    }
}