package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()
{
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var l : Button  = findViewById(R.id.button)

        auth = FirebaseAuth.getInstance()

        l.setOnClickListener {
            login()
        }
    }
    private fun login()
    {
        var e : EditText = findViewById(R.id.EmailAddress)
        var p : EditText = findViewById(R.id.Password)

        val email = e.text.toString()
        val password = p.text.toString()
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this)
        {
            if(it.isSuccessful)
            {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "UNSuccessfully LoggedIn", Toast.LENGTH_SHORT).show()
            }
        }


    }
}