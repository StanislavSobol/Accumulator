package ru.list.sobols.mvvmpart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import ru.list.sobols.BaseFragment;
import ru.list.sobols.MApplication;
import ru.list.sobols.R;
import ru.list.sobols.di.DaggerMvvmPartComponent;
import ru.list.sobols.mvppart.houses.IMvpPartHousesAdapterDelegate;
import ru.list.sobols.mvppart.houses.MvpPartHousesAdapter;

public class MvvmPartHousesFragment extends BaseFragment {

    public static MvvmPartHousesFragment newInstance() {
        return new MvvmPartHousesFragment();
    }

    @Inject
    MvvmPartHousesViewmodelFactory viewModelFactory;

    private MvvmPartHousesViewModel viewModel;


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

        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), layoutManager.getOrientation()));
        final MvpPartHousesAdapter adapter = new MvpPartHousesAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.subscribeToHouses();
        LiveData<List<IMvpPartHousesAdapterDelegate>> liveData = viewModel.getLiveData();
        liveData.observe(this, new Observer<List<IMvpPartHousesAdapterDelegate>>() {
            @Override
            public void onChanged(List<IMvpPartHousesAdapterDelegate> houseListItemDisplayModels) {
                adapter.setItems(houseListItemDisplayModels);
            }
        });
    }

    @NonNull
    @Override
    public String provideActivityTitle() {
        return "MVVM TITLE";
    }
}