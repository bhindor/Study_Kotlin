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
import kr.hs.myfirebasekotlin.databinding.ActivityJoinBinding

class joinActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        // Initialize Firebase Auth
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        val joinBtn = findViewById<Button>(R.id.joinBtn)
        val email = findViewById<EditText>(R.id.emailArea)
        val pwd = findViewById<EditText>(R.id.pwdArea)

        joinBtn.setOnClickListener {
            val email: EditText = binding.emailArea
            val pwd: EditText = binding.pwdArea
            auth.createUserWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, loginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}