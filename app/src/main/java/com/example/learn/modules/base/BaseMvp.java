package com.example.learn.modules.base;

import androidx.annotation.Nullable;

import net.grandcentrix.thirtyinch.TiView;

import io.reactivex.disposables.Disposable;

public interface BaseMvp {
    interface View extends TiView {

    }

    interface Presenter {

        void manageDisposable(@Nullable Disposable disposable);
    }
}
