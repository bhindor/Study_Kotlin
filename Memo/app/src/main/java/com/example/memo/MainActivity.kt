package com.example.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingListener()
    }

    private fun settingListener() {
        binding.floatingBtn.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v) {
            binding.floatingBtn -> {
                //TODO 작성창으로 넘기기
            }
        }
    }
}