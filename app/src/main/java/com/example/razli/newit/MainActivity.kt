package com.example.razli.newit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.razli.newit.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment.newInstance()
    private val browseFragment = BrowseFragment.newInstance()
    private val bookmarksFragment = BookmarksFragment.newInstance()
    private val fragmentManager = supportFragmentManager

    private var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add 3 fragments but hide 2
        fragmentManager.beginTransaction().add(R.id.fragment_container, bookmarksFragment, "2").hide(bookmarksFragment).commit()
        fragmentManager.beginTransaction().add(R.id.fragment_container, browseFragment, "1").hide(browseFragment).commit()
        fragmentManager.beginTransaction().add(R.id.fragment_container, homeFragment, "0").commit()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_tab -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                    activeFragment = homeFragment
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.browse_tab -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(browseFragment).commit()
                    activeFragment = browseFragment
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.bookmark_tab -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(bookmarksFragment).commit()
                    activeFragment = bookmarksFragment
                    return@setOnNavigationItemSelectedListener true
                }

                else -> {
                    // Do nothing
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }
}
