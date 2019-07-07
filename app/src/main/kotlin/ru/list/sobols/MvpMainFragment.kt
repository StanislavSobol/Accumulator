package ru.list.sobols

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