package com.example.learn.modules.base;

import com.example.learn.modules.base.mvp.presenter.BasePresenter;

import net.grandcentrix.thirtyinch.TiActivity;

public abstract class BaseActivity<V extends BaseMvp.View, P extends BasePresenter<V>> extends TiActivity<P, V> implements BaseMvp.View {

}