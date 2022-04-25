package com.example.learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.learn.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {
     private lateinit var binding: ActivitySignupBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignupBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()



        binding.signupbutton.setOnClickListener {

            val email = binding.signupmail.text.toString().trim()
            val password = binding.signuppassword.text.toString().trim()
            val name = binding.signupname.text.toString().trim()

            if (email.isEmpty()){

                binding.signupmail.error = "Email is Empty"
                binding.signupmail.requestFocus()
                return@setOnClickListener
            }

            when {
                name.isEmpty() -> {

                    binding.signupname.error = "Name is Empty"
                    binding.signupname.requestFocus()
                    return@setOnClickListener
                }
                password.isEmpty() -> {

                    binding.signuppassword.error= "Enter password"
                    binding.signuppassword.requestFocus()
                    return@setOnClickListener
                }
                else -> {


                    mAuth.createUserWithEmailAndPassword(email,password)

                        .addOnCompleteListener(this){task->

                            if (task.isSuccessful) {

                                saveUserInfo(name,email,mAuth.currentUser?.uid!!)

                            } else Toast.makeText(this , "Some Error occurred", Toast.LENGTH_LONG).show()


                        }
                }
            }

        }
        }

    private fun saveUserInfo(name: String, email: String,  uid: String) {
        mDbRef =FirebaseDatabase.getInstance().getReference()

        mDbRef.child("user").child(uid).setValue(User(name,email, uid))         // User used here is our User Class that  serves as a dataclass
    }


}



