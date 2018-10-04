package com.example.razli.newit.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.razli.newit.R

class HomeFragment : Fragment(), HomeContract.View {

    override lateinit var presenter: HomeContract.Presenter

    companion object {

        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    init {
        // Create a presenter and tie to this view
        presenter = HomePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun showHi(str: String) {
        Toast.makeText(activity, str, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

}
