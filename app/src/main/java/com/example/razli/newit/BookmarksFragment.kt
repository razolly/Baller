package com.example.razli.newit


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BookmarksFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance(): BookmarksFragment {
            return BookmarksFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bookmarks, container, false)
    }


}
