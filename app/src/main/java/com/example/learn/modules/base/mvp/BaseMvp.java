package com.example.learn.modules.base.mvp;

import net.grandcentrix.thirtyinch.TiView;

public interface BaseMvp {
    interface View extends TiView {

        // Implemented in BaseActivity
        void helloAgain();

        // Implemented in only in MainViewActivity
        void showText();
    }

    interface Presenter {
        void helloWorld();
    }
}
