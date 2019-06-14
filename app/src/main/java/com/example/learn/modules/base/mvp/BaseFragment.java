package com.example.learn.modules.base.mvp;

import com.example.learn.modules.base.BaseMvp;
import com.example.learn.modules.base.mvp.presenter.BasePresenter;

import net.grandcentrix.thirtyinch.TiFragment;

public abstract class BaseFragment<V extends BaseMvp.View, P extends BasePresenter<V>> extends TiFragment<P, V> implements BaseMvp.View {

}
