package com.example.app_que_caique_pediu

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Cor personalizada, você pode mudar o código hexadecimal
            window.statusBarColor = Color.parseColor("#006400")
        }

        //this.supportActionBar?.title = "Example 1"

    }
}