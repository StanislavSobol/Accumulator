package ru.list.sobols.mvppart

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.full_progress_bar_content.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.list.sobols.MApplication
import ru.list.sobols.di.DaggerMvpPartComponent
import ru.list.sobols.di.MvpPartScope
import ru.list.sobols.utils.gone
import ru.list.sobols.utils.show
import javax.inject.Inject

class MvpPartMainFragment : BaseRecyclerViewMvpFragment(), IMvpPartMainView {

    private lateinit var adapter: MvpPartHousesAdapter

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MvpPartHousesAdapter()
        recyclerView.adapter = adapter
    }

    override fun showItems(items: List<IMvpPartMainAdapterDelegate>) {
        adapter.setItems(items)
    }

    override fun showError(throwable: Throwable?) {

    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun hideProgress() {
        progressBar.gone()
    }

    companion object {
        fun newInstance() = MvpPartMainFragment()
    }
}