package com.example.learn.modules.base.mvp.presenter;

import com.example.learn.modules.base.mvp.BaseMvp;

import net.grandcentrix.thirtyinch.TiPresenter;

public class BasePresenter<V extends BaseMvp.View> extends TiPresenter<V> implements BaseMvp.Presenter{

    @Override
    public void helloWorld() {

    }
}
