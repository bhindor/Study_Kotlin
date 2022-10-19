package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(binding.bodyLayout.id, HomeFragment()).commit()

        binding.bottomMenu.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                R.id.homeFragment -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.registerFragment -> {
                    //replaceFragment()
                }
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(binding.bodyLayout.id, fragment).commit()
    }
}