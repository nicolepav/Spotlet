package com.example.spotlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

// Variables


class Register : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var btnregister: Button? = null

    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etEmail = findViewById<View>(R.id.editText_emaillogin_register) as EditText
        etPassword = findViewById<View>(R.id.editText_createpassword) as EditText
        btnregister = findViewById<View>(R.id.button_register) as Button


        mAuth = FirebaseAuth.getInstance()

        btnregister!!.setOnClickListener {
            createNewAccount()
            // redirect to home page
             val intent = Intent(this, AltMap::class.java)
             startActivity(intent)
        }

    }

    private fun createNewAccount() {
        email = etEmail?.text.toString()
        password = etPassword?.text.toString()

//        Log.d("DEBUG", email)
//        Log.d("DEBUG", password)

        mAuth!!
            .createUserWithEmailAndPassword(email!!, password!!).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val userId = mAuth!!.currentUser!!.uid

                    Log.d("DEBUG", userId)
                    Toast.makeText(this, "Registeration succeeded. \n"+userId,
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("DEBUG", "WE FAILED")

                    Toast.makeText(this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}


