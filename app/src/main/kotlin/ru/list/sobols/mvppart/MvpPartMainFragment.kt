package ru.list.sobols.mvppart

import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.list.sobols.MApplication
import ru.list.sobols.di.DaggerMvpPartComponent
import ru.list.sobols.di.MvpPartScope
import ru.list.sobols.model.HouseModel
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

    override fun showItems(items: List<HouseModel>?) {
        //  Log.d("SSS", items.toString())
    }

    override fun showError(throwable: Throwable?) {

    }

    companion object {
        fun newInstance() = MvpPartMainFragment()
    }
}