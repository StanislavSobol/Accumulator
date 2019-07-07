package ru.list.sobols.mvppart

import android.os.Bundle
import android.view.View
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MvpPartMainFragment : BaseRecyclerViewMvpFragment(), IMvpPartMainView {

    @InjectPresenter
    lateinit var presenter: MvpPartMainPresenter

    @ProvidePresenter
    fun providePresenter() = MvpPartMainPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = MvpPartMainFragment()
    }
}