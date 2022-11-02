package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class App: AppCompatActivity() {
    companion object {
        lateinit var prefs : MySharedPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        prefs = MySharedPreferences(applicationContext)
        super.onCreate(savedInstanceState)
    }
}