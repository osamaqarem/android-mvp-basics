package com.example.learn.modules.base.mvp.presenter;

import androidx.annotation.Nullable;

import com.example.learn.modules.base.BaseMvp;

import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.rx2.RxTiPresenterDisposableHandler;

import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends BaseMvp.View> extends TiPresenter<V> implements BaseMvp.Presenter {

    // Handling disposables
    private RxTiPresenterDisposableHandler disposableHandler = new RxTiPresenterDisposableHandler(this);

    @Override
    public void manageDisposable(@Nullable Disposable disposable) {
        if (disposable != null) {
            disposableHandler.manageDisposable(disposable);
        }
    }
}
