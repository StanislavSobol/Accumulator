package ru.list.sobols.mvppart.houses

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.full_progress_bar_content.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.list.sobols.MApplication
import ru.list.sobols.di.DaggerMvpPartComponent
import ru.list.sobols.di.MvpPartScope
import ru.list.sobols.mvppart.MvpPartBaseRecyclerViewFragment
import ru.list.sobols.utils.gone
import ru.list.sobols.utils.hide
import ru.list.sobols.utils.show
import javax.inject.Inject

class MvpPartHousesFragment : MvpPartBaseRecyclerViewFragment(), IMvpPartHousesView {

    private lateinit var adapter: MvpPartHousesAdapter

    @MvpPartScope
    @Inject
    @InjectPresenter
    lateinit var presenter: MvpPartHousesPresenter

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
        swipeRefreshLayout.setOnRefreshListener { presenter.onSwipeToRefresh() }
    }

    override fun showItems(items: List<IMvpPartHousesAdapterDelegate>) {
        adapter.setItems(items)
    }

    override fun showError(throwable: Throwable?) {

    }

    override fun showProgress() {
        if (!swipeRefreshLayout.isRefreshing) {
            progressBar.show()
            recyclerView.hide()
        }
    }

    override fun hideProgress() {
        if (swipeRefreshLayout.isRefreshing) {
            swipeRefreshLayout.isRefreshing = false
        } else {
            progressBar.gone()
            recyclerView.show()
        }
    }

    companion object {
        fun newInstance() = MvpPartHousesFragment()
    }
}