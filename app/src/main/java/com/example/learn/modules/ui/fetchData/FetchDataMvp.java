package com.example.learn.modules.ui.fetchData;

import com.example.learn.modules.base.BaseMvp;

public interface FetchDataMvp {

    interface View extends BaseMvp.View {

    }

    interface Presenter extends BaseMvp.Presenter {

        // Fetch list of repos
        void fetchRepos();
    }
}
