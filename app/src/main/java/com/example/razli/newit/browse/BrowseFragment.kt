package com.example.razli.newit.browse


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razli.newit.R

class BrowseFragment : Fragment(), BrowseContract.View {

    override var presenter: BrowseContract.Presenter = BrowsePresenter(this)

    companion object {

        @JvmStatic
        fun newInstance(): BrowseFragment {
            return BrowseFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }


}
