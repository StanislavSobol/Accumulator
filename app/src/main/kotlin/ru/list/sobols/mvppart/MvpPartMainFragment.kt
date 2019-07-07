package ru.list.sobols.mvppart

import android.os.Bundle
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.list.sobols.MApplication
import javax.inject.Inject

class MvpPartMainFragment : BaseRecyclerViewMvpFragment(), IMvpPartMainView {

    @Inject
    @InjectPresenter
    lateinit var presenter: MvpPartMainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    init {
        MApplication.getDaggerComponents().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = MvpPartMainFragment()
    }
}