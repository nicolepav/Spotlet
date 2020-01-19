package com.example.spotlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserListingPriceSize : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_listing_price_size)
        val btn_listing_submit = findViewById<Button>(R.id.button_listing_submit)

        btn_listing_submit.setOnClickListener{
            val intent = Intent(this, Listing::class.java)
            startActivity(intent)
        }
    }
}
