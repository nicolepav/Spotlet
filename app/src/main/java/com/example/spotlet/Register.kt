package com.example.spotlet

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
    private var btnCreateAccount: Button? = null

    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etEmail = findViewById<View>(R.id.editText_emaillogin_register) as EditText
        etPassword = findViewById<View>(R.id.editText_createpassword) as EditText
        btnCreateAccount = findViewById<View>(R.id.button_register) as Button


        mAuth = FirebaseAuth.getInstance()

        btnCreateAccount!!.setOnClickListener { createNewAccount() }


//        this.mAuth.createUserWithEmailAndPassword(newuseremail, newuserpassword).addOnCompleteListener { task: Task<AuthResult> ->
//            if (task.isSuccessful) {
//                val firebaseUser = this.mAuth.currentUser!!
//            } else {
//                Toast.makeText(this,"Account creation failed", Toast.LENGTH_SHORT)
//            }
//        }

    }

    private fun createNewAccount() {
        email = etEmail?.text.toString()
        password = etPassword?.text.toString()

        Log.d("DEBUG", email)
        Log.d("DEBUG", password)

        mAuth!!
            .createUserWithEmailAndPassword(email!!, password!!).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val userId = mAuth!!.currentUser!!.uid

                    Log.d("DEBUG", userId)
                    Toast.makeText(this, "Register success. "+userId,
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("DEBUG", "WE FAILED")

                    Toast.makeText(this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}


