package com.example.razli.newit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, HomeFragment.newInstance(), "HomeFragment")
                    .commit()
        }*/

        val homeFragment = HomeFragment.newInstance()
        val browseFragment = BrowseFragment.newInstance()
        val bookmarksFragment = BookmarksFragment.newInstance()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_tab -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    setFragment(homeFragment)
                }

                R.id.browse_tab -> {
                    Toast.makeText(this, "Browse", Toast.LENGTH_SHORT).show()
                    setFragment(browseFragment)
                }

                R.id.bookmark_tab -> {
                    Toast.makeText(this, "Bookmark", Toast.LENGTH_SHORT).show()
                    setFragment(bookmarksFragment)
                }

                else -> {
                    // Do nothing
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setFragment(fragment: Fragment) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction
                .replace(R.id.fragment_container, fragment)
                .commit()

    }
}
