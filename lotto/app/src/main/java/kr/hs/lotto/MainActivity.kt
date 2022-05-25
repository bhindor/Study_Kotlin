package kr.hs.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private val clearButton: Button by lazy{
        findViewById(R.id.clearBtn)
    }
    private val addButton: Button by lazy {
        findViewById(R.id.addBtn)
    }
    private val runButton: Button by lazy {
        findViewById(R.id.runBtn)
    }
    private val numPicker: NumberPicker by lazy {
        findViewById(R.id.numPicker)
    }
    private val numberTextViewList: List<TextView> by lazy{
        listOf<TextView>(
            findViewById<TextView>(R.id.tv_one),
            findViewById<TextView>(R.id.tv_two),
            findViewById<TextView>(R.id.tv_three),
            findViewById<TextView>(R.id.tv_four),
            findViewById<TextView>(R.id.tv_five),
            findViewById<TextView>(R.id.tv_six)
        )
    }
    private var didRun = false
    private val pickNumberSet = hashSetOf<Int>() //set 중복된 정보가 들어가지않음, list 순차적으로 정보가 쌓이는 자료구조형
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numPicker.minValue = 1
        numPicker.maxValue = 45

        initRunButton()
        initAddButton()
        initClearButton()
    }

    private fun initRunButton(){
        runButton.setOnClickListener {
            val list = getRandomNumber()
            didRun = true
            list.forEachIndexed{ index, number ->
                val textView = numberTextViewList[index]

                textView.text = number.toString()
                textView.isVisible = true

//                when(number){
//                    in 1..10 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_yellow)
//                    in 11..20 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_blue)
//                    in 21..30 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_red)
//                    in 31..40 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gray)
//                    else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_green)
//                }
                setNumberBackground(number ,textView)
            }
            //Log.d("MainActivity", list.toString()) 잘받아왔는지 보기위한 log
        }
    }
    private fun initAddButton(){
        addButton.setOnClickListener {
            if(didRun){
                Toast.makeText(this, "초기화 후에 시도해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pickNumberSet.size >= 5){
                Toast.makeText(this, "번호는 5개까지만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pickNumberSet.contains(numPicker.value)){
                Toast.makeText(this, "이미 선택된 번호입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val textView = numberTextViewList[pickNumberSet.size]
            textView.isVisible = true
            textView.text = numPicker.value.toString()

            setNumberBackground(numPicker.value, textView)

            pickNumberSet.add(numPicker.value)

        }
    }
    private fun setNumberBackground(number:Int, textView: TextView){
        when(number){
            in 1..10 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_yellow)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_blue)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_red)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gray)
            else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_green)
        }
    }
    private fun initClearButton(){
        clearButton.setOnClickListener {
            pickNumberSet.clear()
            numberTextViewList.forEach{
                it.isVisible = false
            }
            didRun = false
        }
    }
    private fun getRandomNumber(): List<Int> {
        val numList = mutableListOf<Int>().apply { //mutableListOf add로 뒤에 붙여넣기 가능 읽기/쓰기 , List는 읽기 전용, apply를 사용한 객체를 this로 호출 가능
                for (i in 1..45) {
                    if(pickNumberSet.contains(i)){
                        continue
                    }
                    this.add(i)
                }
            }
        numList.shuffle()

        val newList = pickNumberSet.toList() + numList.subList(0, 6 - pickNumberSet.size)

        return newList.sorted()
    }

}