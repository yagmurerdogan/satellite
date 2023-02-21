package com.yagmurerdogan.satellite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yagmurerdogan.satellite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}