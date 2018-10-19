package com.example.renanalves.loginwithsharedpreferencekotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)

        btnLogar.setOnClickListener {

            if(sharedPreferences.getBoolean("firstLoad", false) == false) {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, Main4Activity::class.java)
                startActivity(intent)
            }

        }
    }
}
