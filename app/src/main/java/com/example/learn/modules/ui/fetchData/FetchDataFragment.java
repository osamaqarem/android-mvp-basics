package com.example.learn.modules.ui.fetchData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learn.R;
import com.example.learn.modules.base.mvp.BaseFragment;

public class FetchDataFragment extends BaseFragment<FetchDataMvp.View, FetchDataPresenter> implements FetchDataMvp.View {

    @NonNull
    @Override
    public FetchDataPresenter providePresenter() {
        return new FetchDataPresenter();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FetchDataPresenter mPresenter = getPresenter();

        mPresenter.fetchRepos();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_fetch_data, container, false);
    }
}
