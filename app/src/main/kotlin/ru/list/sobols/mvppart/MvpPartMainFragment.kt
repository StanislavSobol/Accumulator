package ru.list.sobols.mvppart

import android.os.Bundle
import android.util.Log
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.list.sobols.MApplication
import ru.list.sobols.di.DaggerMvpPartComponent
import ru.list.sobols.di.MvpPartScope
import javax.inject.Inject

class MvpPartMainFragment : BaseRecyclerViewMvpFragment(), IMvpPartMainView {

    @MvpPartScope
    @Inject
    @InjectPresenter
    lateinit var presenter: MvpPartMainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    init {
        DaggerMvpPartComponent.builder()
                .appComponent(MApplication.getDaggerComponents())
                .build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        if (savedInstanceState == null) {
//            DaggerMvpPartComponent.builder()
//                    .appComponent(MApplication.getDaggerComponents())
//                    .build().inject(this)
//        }
        //     MApplication.getDaggerComponents().inject(this)
        super.onCreate(savedInstanceState)
        Log.d("SSS", "MvpPartMainFragment presenter = $presenter")
    }

    companion object {
        fun newInstance() = MvpPartMainFragment()
    }
}