package ru.list.sobols

import android.os.Bundle
import android.view.View

class MvvmMainFragment : BaseRecyclerViewMvpFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = MvvmMainFragment()
    }
}