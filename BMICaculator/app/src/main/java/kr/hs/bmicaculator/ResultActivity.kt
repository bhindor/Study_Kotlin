package kr.hs.bmicaculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height, weight : $weight")

        //val bmi = weight / Math.pow(height / 100.0, 2.0) //cm 단위로 입력받는데 m단위로 해줘야해서 100으로 나눈 뒤 제곱
        val bmi = weight / (height/100.0).pow(2.0)
        val tv_result = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val tv_bmi = findViewById<TextView>(R.id.tv_bmi)
        val tv_results = findViewById<TextView>(R.id.tv_result)
//        tv_bmi.setText(bmi.toString())
//        tv_results.setText(tv_result)
        tv_bmi.text = bmi.toString()
        tv_results.text = tv_result
    }
}