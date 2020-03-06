package com.cis.lab.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

       val data = intent.getStringExtra("selectedname")
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show()
    }
}
