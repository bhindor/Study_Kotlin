package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.example.todolist.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<View>(R.id.bottom_menu) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().replace(binding.bodyLayout.id, HomeFragment()).commit()
    }
//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().add(binding.bodyLayout.id, fragment).commit()
//    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                supportFragmentManager.beginTransaction().replace(binding.bodyLayout.id, HomeFragment()).commit()
            }
            R.id.write -> {
                supportFragmentManager.beginTransaction().replace(binding.bodyLayout.id, WriteFragment()).commit()
            }
        }
        return true
    }
}