package kr.hs.secret_diary

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private val numPick1: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numPick1)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val numPick2: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numPick2)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val numPick3: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numPick3)
            .apply {
                minValue = 0
                maxValue = 9
            }
    }
    private val openBtn: AppCompatButton by lazy {
        findViewById(R.id.openBtn)
    }
    private val changePwBtn: AppCompatButton by lazy {
        findViewById(R.id.changePwBtn)
    }
    private var changePwMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numPick1
        numPick2
        numPick3

        openBtn.setOnClickListener {

            if(changePwMode){
                Toast.makeText(this, "비밀번호 변경 중", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pwPreferences = getSharedPreferences("pw", Context.MODE_PRIVATE)

            val pwFromUser = "${numPick1.value}${numPick2.value}${numPick3.value}"

            if(pwPreferences.getString("pw", "000").equals(pwFromUser)){
                //패스워드 성공
//                val intent = Intent(this, DiaryActivity::class.java)
//                startActivity(intent)
                startActivity(Intent(this, DiaryActivity::class.java))
            }else{
                showErrorAlterDialog()
            }
        }
        changePwBtn.setOnClickListener {
            val pwPreferences = getSharedPreferences("pw", Context.MODE_PRIVATE)
            val pwFromUser = "${numPick1.value}${numPick2.value}${numPick3.value}"
            if(changePwMode){
//                pwPreferences.edit {
//                    val pwFromUser = "${numPick1.value}${numPick2.value}${numPick3.value}"
//                    putString("pw", "$pwFromUser")
//                    commit()
//                }
                pwPreferences.edit(true) {
                    putString("pw", "$pwFromUser")
                }
                changePwMode = false
                changePwBtn.setBackgroundColor(Color.BLACK)
            }else{
                val pwPreferences = getSharedPreferences("pw", Context.MODE_PRIVATE)

                val pwFromUser = "${numPick1.value}${numPick2.value}${numPick3.value}"

                if(pwPreferences.getString("pw", "000").equals(pwFromUser)){
                    changePwMode = true
                    Toast.makeText(this, "변경할 패스워드를 입력해주세요", Toast.LENGTH_SHORT).show()
                    changePwBtn.setBackgroundColor(Color.RED)
                }else{
                    showErrorAlterDialog()
                }
            }
        }

    }
    private fun showErrorAlterDialog(){
        //실패
        AlertDialog.Builder(this)
            .setTitle("실패")
            .setMessage("비밀번호가 잘못되었습니다")
            .setPositiveButton("확인"){ _, _ -> }
            .create()
            .show()
    }
}