package com.example.spotlet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    //Firebase references
    private var mAuth: FirebaseAuth? = null

//    private FirebaseAuth mAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
    }


}
