package ru.list.sobols.mvplib

import android.os.Bundle
import android.view.View

class MvpMainFragment : BaseRecyclerViewMvpFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = MvpMainFragment()
    }
}