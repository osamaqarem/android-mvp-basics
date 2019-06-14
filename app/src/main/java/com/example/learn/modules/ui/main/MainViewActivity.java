package com.example.learn.modules.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.learn.R;
import com.example.learn.modules.base.BaseActivity;
import com.example.learn.modules.ui.fetchData.FetchDataFragment;

public class MainViewActivity extends BaseActivity<MainViewInt.View, MainPresenter> implements MainViewInt.View {

    @NonNull
    @Override
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FetchDataFragment fetchDataFragment = new FetchDataFragment();

        fragmentTransaction.replace(R.id.frame_fetch_data, fetchDataFragment);
        fragmentTransaction.commit();
    }


}
