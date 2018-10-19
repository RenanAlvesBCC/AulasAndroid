package com.example.renanalves.loginwithsharedpreferencekotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvEntrada.setText("Bem Vindo")

        btnSair.setOnClickListener {
            intent = Intent(this,Main4Activity::class.java)
            startActivity(intent)
        }
    }
}
