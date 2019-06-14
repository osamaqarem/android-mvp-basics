package com.example.learn.modules.ui.fetchMessages;

import android.support.annotation.NonNull;

import com.example.learn.modules.base.mvp.BaseFragment;

public class FetchMessagesFragment extends BaseFragment<FetchMessagesMvp.View, FetchMessagesPresenter> implements FetchMessagesMvp.View {

    @NonNull
    @Override
    public FetchMessagesPresenter providePresenter() {
        return null;
    }

    @Override
    public void showText() {

    }
}
