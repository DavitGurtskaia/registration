package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registration.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            var email = binding.email
            var password = binding.password
            if (email.text.toString() != "" && password.text.toString() != "") {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                        }

                    }

            }
        }
    }
}