package com.example.renanalves.emprestimoapp.Model.Notification

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result_notification.*
import com.example.renanalves.emprestimoapp.R

class ResultNotificationActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_notification)

        if (intent.getBooleanExtra("notification", false)) { //Just for confirmation
            txtTitleView.text = intent.getStringExtra("title")
            txtMsgView.text = intent.getStringExtra("message")
        }
    }
}
