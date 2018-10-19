package com.example.renanalves.loginwithsharedpreferencekotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        val edit = sharedPreferences.edit()
        edit.putBoolean("firstLoad",true)
        edit.apply()

        tvMenu.setText("MENU PRINCIPAL")

        btnQuit.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
