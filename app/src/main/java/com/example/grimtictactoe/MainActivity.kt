package com.example.grimtictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View){
        val intent = Intent(this, GameActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun vsAi(view: View){
        Toast.makeText(this, "Not implemented yet.", Toast.LENGTH_LONG).show()
    }
}
