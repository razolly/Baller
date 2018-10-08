package com.example.razli.newit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import com.example.razli.newit.bookmarks.BookmarksFragment
import com.example.razli.newit.browse.BrowseFragment
import com.example.razli.newit.chooseteam.ChooseTeamActivity
import com.example.razli.newit.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment.newInstance()
    private val browseFragment = BrowseFragment.newInstance()
    private val bookmarksFragment = BookmarksFragment.newInstance()
    private val fragmentManager = supportFragmentManager

    private var activeFragment: Fragment = homeFragment

    companion object {

        val REQUEST_CHOOSE_TEAM = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpFragments()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_right_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.pick_team -> {
                startChooseTeamActivity()
                return true
            }
        }
        return false
    }

    private fun startChooseTeamActivity() {
        val intent = Intent(this, ChooseTeamActivity::class.java)
        startActivityForResult(intent, REQUEST_CHOOSE_TEAM)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CHOOSE_TEAM -> {
                // Might need to look at API endpoint that gets names of all league and team names
            }
        }
    }

    private fun setUpFragments() {

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
