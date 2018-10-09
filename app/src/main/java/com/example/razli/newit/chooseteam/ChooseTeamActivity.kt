package com.example.razli.newit.chooseteam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razli.newit.R
import com.example.razli.newit.network.Competition
import kotlinx.android.synthetic.main.activity_choose_team.*
import kotlinx.android.synthetic.main.item_horizontal_league.view.*

class ChooseTeamActivity : AppCompatActivity(), ChooseTeamContract.View {

    override var presenter: ChooseTeamContract.Presenter = ChooseTeamPresenter(this)

    companion object {

        val EXTRA_CHOSEN_TEAM = "com.example.razli.newit.ChooseTeamActivity.EXTRA_CHOSEN_TEAM"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_team)
        competition_container.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.getCompetitionList()
    }

    override fun showCompetitions(competitionList: List<Competition>) {
        competition_container.adapter = CompetitionListAdapter(competitionList)
    }
}


class CompetitionListAdapter(private val competitions: List<Competition>)
    : RecyclerView.Adapter<CompetitionListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal_league, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCompetition(competitions[position])
    }

    override fun getItemCount(): Int = competitions.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindCompetition(competition: Competition) {
            with(competition) {
                // itemView.league_name.text = competition.name

                val imageResource = when (competition.name) {
                    "Championship" -> R.drawable.ic_championship
                    "Primera Division" -> R.drawable.ic_laliga
                    "Bundesliga" -> R.drawable.ic_bundesliga
                    "Premier League" -> R.drawable.ic_epl
                    "Serie A" -> R.drawable.ic_seriea
                    else -> R.drawable.ic_epl
                }

                itemView.league_image.setImageResource(imageResource)
            }
        }
    }
}
