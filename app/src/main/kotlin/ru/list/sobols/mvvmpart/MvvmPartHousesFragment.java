package ru.list.sobols.mvvmpart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import ru.list.sobols.BaseFragment;
import ru.list.sobols.MApplication;
import ru.list.sobols.R;
import ru.list.sobols.di.DaggerMvvmPartComponent;

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

        //  viewModel = ViewModelProviders.of(this).get(MvvmPartHousesViewModel.class);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MvvmPartHousesViewModel.class);
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @NonNull
    @Override
    public String provideActivityTitle() {
        return "MVVM TITLE";
    }
}