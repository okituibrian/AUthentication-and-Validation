package com.example.e_dawapharmacy

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_dawapharmacy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {
    private lateinit var mbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mbinding.root)

    }

        private fun validateName(){
            val error: String?
            val fullName = String
           // val value: String = mbinding.fullName.text.toString()

        }
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onFocusChange(p0: View?, p1: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }
}