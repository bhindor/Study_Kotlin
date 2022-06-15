package kr.hs.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kr.hs.diceapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val diceImg1: ImageView by lazy {
        findViewById(R.id.dice1)
    }
    val diceImg2: ImageView by lazy {
        findViewById(R.id.dice2)
    }
    val StartBtn: Button by lazy {
        findViewById(R.id.diceStartBtn)
    }
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StartBtn.setOnClickListener {
            Toast.makeText(this, "주사위 굴리기!", Toast.LENGTH_SHORT).show()

            val number = Random.nextInt(1, 6)
            val number2 = Random.nextInt(1, 6)

            when(number){
                1->diceImg1.setImageResource(R.drawable.dice_1)
                2->diceImg1.setImageResource(R.drawable.dice_2)
                3->diceImg1.setImageResource(R.drawable.dice_3)
                4->diceImg1.setImageResource(R.drawable.dice_4)
                5->diceImg1.setImageResource(R.drawable.dice_5)
                6->diceImg1.setImageResource(R.drawable.dice_6)
            }
            when(number2){
                1->diceImg2.setImageResource(R.drawable.dice_1)
                2->diceImg2.setImageResource(R.drawable.dice_2)
                3->diceImg2.setImageResource(R.drawable.dice_3)
                4->diceImg2.setImageResource(R.drawable.dice_4)
                5->diceImg2.setImageResource(R.drawable.dice_5)
                6->diceImg2.setImageResource(R.drawable.dice_6)
            }
        }
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val diceImage1 = binding.dice1
//        val diceImage2 = binding.dice2

        /*binding.diceStartBtn.setOnClickListener {
            Toast.makeText(this, "주사위 GO!", Toast.LENGTH_SHORT).show()

            Log.d("MainActivity", Random.nextInt(1, 6).toString())
            Log.d("MainActivity", Random.nextInt(1, 6).toString())

            val number = Random.nextInt(1, 6)
            val number2 = Random.nextInt(1, 6)

            when(number){
                1 -> diceImage1.setImageResource(R.drawable.dice_1)
                2 -> diceImage1.setImageResource(R.drawable.dice_2)
                3 -> diceImage1.setImageResource(R.drawable.dice_3)
                4 -> diceImage1.setImageResource(R.drawable.dice_4)
                5 -> diceImage1.setImageResource(R.drawable.dice_5)
                6 -> diceImage1.setImageResource(R.drawable.dice_6)
            }
            when(number2){
                1 -> diceImage2.setImageResource(R.drawable.dice_1)
                2 -> diceImage2.setImageResource(R.drawable.dice_2)
                3 -> diceImage2.setImageResource(R.drawable.dice_3)
                4 -> diceImage2.setImageResource(R.drawable.dice_4)
                5 -> diceImage2.setImageResource(R.drawable.dice_5)
                6 -> diceImage2.setImageResource(R.drawable.dice_6)
            }
        }*/

    }
}