package com.example.razli.newit.chooseteam

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.razli.newit.MainActivity
import com.example.razli.newit.R

class ChooseTeamActivity : AppCompatActivity() {

    companion object {

        val EXTRA_CHOSEN_TEAM = "com.example.razli.newit.ChooseTeamActivity.EXTRA_CHOSEN_TEAM"

        /*fun start(context: Context) {
            val intent = Intent(context, ChooseTeamActivity::class.java)
            context.startActivity(intent)
        }*/

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_team)
    }

    // TODO make function to return chosen team to mainactivity
}
