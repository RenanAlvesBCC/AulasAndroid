package com.example.renanalves.checkpreferencesandapimoeda

import android.app.Activity
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        setValue.setOnClickListener {
            var editor = sharedPreference.edit()
            editor.putString("nome","Renan Alves")
            editor.commit()
        }

        getValue.setOnClickListener {
            var nome = sharedPreference.getString("nome","defaultName")
            tvNome.setText(nome)
        }

        clearValue.setOnClickListener {
            var editor = sharedPreference.edit()
            editor.clear().commit()
        }
    }
}
