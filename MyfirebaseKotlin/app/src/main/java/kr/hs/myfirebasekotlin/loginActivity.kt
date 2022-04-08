package kr.hs.myfirebasekotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.hs.myfirebasekotlin.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.loginBtn.setOnClickListener {
            val email: EditText = binding.emailArea
            val pwd: EditText = binding.pwdArea
            if (email.text.isEmpty() || pwd.text.isEmpty()) {
                Toast.makeText(this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, BoardListActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
                        }
                    }

            }
        }
        val joinBtn = findViewById<Button>(R.id.go_joinBtn)
        joinBtn.setOnClickListener {
            val intent = Intent(this, joinActivity::class.java)
            startActivity(intent)
        }
    }
}