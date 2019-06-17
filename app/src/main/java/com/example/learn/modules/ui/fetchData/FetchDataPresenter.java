package com.example.learn.modules.ui.fetchData;

import android.util.Log;

import com.example.learn.data.dao.types.GithubResponseModel;
import com.example.learn.data.service.ReposService;
import com.example.learn.modules.base.mvp.presenter.BasePresenter;
import com.example.learn.provider.rest.RestProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class FetchDataPresenter extends BasePresenter<FetchDataMvp.View> implements FetchDataMvp.Presenter {


    private static void logResult(List<GithubResponseModel> githubResponseModels) {
        Log.d("response", "Inside the lambda");
    }

    @Override
    public void fetchRepos() {
        // Get the retrofit object with the baseURL
        // Use retrofit to create the API
        Retrofit retrofit = RestProvider.getRetrofit();

        ReposService reposServices = retrofit.create(ReposService.class);
        
        Observable<List<GithubResponseModel>> reposRequestRx = reposServices.listReposRx("osamaq");

        Disposable disposable = reposRequestRx
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(FetchDataPresenter::logResult, Throwable::printStackTrace
                );

        manageDisposable(disposable);
    }

}