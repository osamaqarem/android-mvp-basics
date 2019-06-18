package com.example.learn.modules.ui.fetchData;

import android.util.Log;

import com.example.learn.App;
import com.example.learn.data.dao.types.GithubResponseModelEntity;
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

    private void insertData(List<GithubResponseModelEntity> githubResponseModels) {

        // License and Owner must be entities. Getters and Setters for each must be set as well.
        Disposable disposable = App.instance().getDataSource()
                .upsert(githubResponseModels)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(githubResponseModelEntities -> logResultFromDb(githubResponseModelEntities.iterator().next()));


        // Select from existing data
//        Disposable disposable = App.instance().getDataSource()
//                .select(GithubResponseModelEntity.OWNER)
//                .get()
//                .observable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(result -> {
//                    Log.d("db", "insertData: " + result);
//                }, throwable -> {
//                    throwable.printStackTrace();
//                });


        manageDisposable(disposable);
    }

    private void logResultFromDb(GithubResponseModelEntity entity) {
        Log.d("db", "Stored in DB. Model" + entity.getOwner());
    }


    @Override
    public void fetchRepos() {
        // Get the retrofit object with the baseURL
        // Use retrofit to create the API
        Retrofit retrofit = RestProvider.getRetrofit();

        ReposService reposService = retrofit.create(ReposService.class);

        Observable<List<GithubResponseModelEntity>> reposRequestRxEntity = reposService.listReposRxEntity("osamaq");

        Disposable disposable = reposRequestRxEntity
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::insertData, Throwable::printStackTrace);

        manageDisposable(disposable);

    }

}