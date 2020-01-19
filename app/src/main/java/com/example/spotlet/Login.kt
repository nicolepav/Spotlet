package com.example.spotlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

val db = FirebaseFirestore.getInstance()

class Login : AppCompatActivity() {


    private var mAuth: FirebaseAuth? = null

    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var btnlogin: Button? = null

    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById<View>(R.id.editText_emaillogin) as EditText
        etPassword = findViewById<View>(R.id.editText_passwordlogin) as EditText
        btnlogin = findViewById<View>(R.id.button_login) as Button
        mAuth = FirebaseAuth.getInstance()

        val entry = hashMapOf(
            "lat" to 3,
            "lng" to 5,
            "rate_hour" to 3
        )


        db.collection("listings").add(entry)
            .addOnSuccessListener { Log.d("sdf", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("SDfsd", "Error writing document", e) }
        db.collection("listings").document("As66X6KeMd7QyatQHpwv").get().addOnSuccessListener {
            document ->
                if (document != null) {
                    Log.d("ifnotnukk", "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d("else", "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d("failurelistener", "get failed with ", exception)
            }


            btnlogin!!.setOnClickListener {
            login()
            val intent = Intent(this, AltMap::class.java)
            startActivity(intent)

        }
    }

    private fun login() {
//        val db = FirebaseFirestore.getInstance()

        email = etEmail?.text.toString()
        password = etPassword?.text.toString()

        mAuth!!.signInWithEmailAndPassword(email!!, password!!).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with signed-in user's information
                    // redirect to home
                    Toast.makeText(this, "Authentication succeeded.",
                        Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }

    }
}
