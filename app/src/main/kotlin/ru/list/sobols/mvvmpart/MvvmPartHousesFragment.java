package ru.list.sobols.mvvmpart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import javax.inject.Inject;

import ru.list.sobols.BaseFragment;
import ru.list.sobols.MApplication;
import ru.list.sobols.R;
import ru.list.sobols.di.DaggerMvvmPartComponent;
import ru.list.sobols.mvppart.houses.MvpPartHousesAdapter;

public class MvvmPartHousesFragment extends BaseFragment {

    public static MvvmPartHousesFragment newInstance() {
        return new MvvmPartHousesFragment();
    }

    @Inject
    MvvmPartHousesViewmodelFactory viewModelFactory;

    private MvvmPartHousesViewModel viewModel;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState) {
        DaggerMvvmPartComponent.builder()
                .appComponent(MApplication.Companion.getDaggerComponents())
                .build().inject(this);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MvvmPartHousesViewModel.class);
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), layoutManager.getOrientation()));
        final MvpPartHousesAdapter adapter = new MvpPartHousesAdapter();
        recyclerView.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progressBar);

        viewModel.getProgressLiveData().observe(this, this::setProgressVisibility);
        viewModel.subscribeToHouses().observe(this, adapter::setItems);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(() -> viewModel.requestHouses());
    }

    @NonNull
    @Override
    public String provideActivityTitle() {
        return "MVVM TITLE";
    }

    private void setProgressVisibility(boolean visible) {
        if (visible) {
            if (!swipeRefreshLayout.isRefreshing()) {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
            }
        } else {
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);
            } else {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        }
    }
}