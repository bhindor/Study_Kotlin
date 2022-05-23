package kr.hs.bmicaculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val height : EditText = findViewById(R.id.heightEditText)
        val weight = findViewById<EditText>(R.id.weightEditText)
        val resultBtn = findViewById<Button>(R.id.resultBtn)

        resultBtn.setOnClickListener {
            //Log.d("MainActvity", "button이 클릭되었습니다")

            if (height.text.isEmpty() || weight.text.isEmpty()) {
                Toast.makeText(this, "빈칸을 채워 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height_result: Int = height.text.toString().toInt()
            val weight_result: Int = weight.text.toString().toInt()
            //Log.d("MainActivity", "height : $height_result weight : $weight_result") //tap / shift+tap / ctrl + art + l

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height_result)
            intent.putExtra("weight", weight_result)
            startActivity(intent)
        }
    }
}