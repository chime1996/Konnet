package com.example.learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.learn.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
        mAuth =  FirebaseAuth.getInstance()

        binding.textViewLogin.setOnClickListener {


            val inte = Intent(this,Signup::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(inte)


        }



        binding.loginButton.setOnClickListener {


           val email = binding.loginemail.text.toString().trim()
            val password = binding.loginpassword.text.toString().trim()

            if (email.isEmpty()){

                binding.loginemail.error = "Email is Empty"
                binding.loginemail.requestFocus()
                return@setOnClickListener
            }
            else if (password.isEmpty()) {

                binding.loginpassword.error= "Enter password"
                binding.loginpassword.requestFocus()
                return@setOnClickListener
            }
             else loginUser(email, password)

        }

    }

    private fun loginUser(email: String, password: String) {
        mAuth . signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->

                if (task.isSuccessful){

                    registerIntent()
                }
                else Toast.makeText(this, "User does not exist",Toast.LENGTH_SHORT).show()

            }

    }

    private fun registerIntent() {
        val intent = Intent(this,MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }
}