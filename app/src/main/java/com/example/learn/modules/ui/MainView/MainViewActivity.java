package com.example.learn.modules.ui.MainView;

import android.support.annotation.NonNull;

import com.example.learn.modules.base.BaseActivity;

public class MainViewActivity extends BaseActivity<MainViewInt.View, MainPresenter> implements MainViewInt.View {

    @NonNull
    @Override
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }


    @Override
    public void showText() {
    }


}
