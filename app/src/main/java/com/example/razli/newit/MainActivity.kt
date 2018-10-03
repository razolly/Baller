package com.example.razli.newit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_tab -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }

                R.id.browse_tab -> {
                    Toast.makeText(this, "Browse", Toast.LENGTH_SHORT).show()
                }

                R.id.bookmark_tab -> {
                    Toast.makeText(this, "Bookmark", Toast.LENGTH_SHORT).show()
                }

                else -> {

                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
