package com.example.learn.modules.base;

import net.grandcentrix.thirtyinch.TiView;

public interface BaseMvp {
    interface View extends TiView {

        // Implemented in BaseActivity / BaseFragment
        void helloAgain();

        // Implemented in only in MainViewActivity / FetchMessagesFragment
        void showText();
    }

    interface Presenter {
        void helloWorld();
    }
}
