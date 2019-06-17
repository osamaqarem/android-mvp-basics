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

    @Override
    public void fetchRepos() {
        // Get the retrofit object with the baseURL
        // Use retrofit to create the API
        Retrofit retrofit = RestProvider.getRetrofit();

        ReposService reposServices = retrofit.create(ReposService.class);

//        Call<List<GithubResponseModel>> reposRequest = reposServices.listRepos("osamaq");
//
//   //      Async queue the request. Callback to handle the result.
//        reposRequest.enqueue(new Callback<List<GithubResponseModel>>() {
//            @Override
//            public void onResponse(Call<List<GithubResponseModel>> call, Response<List<GithubResponseModel>> response) {
//
//                List<GithubResponseModel> result = null;
//                try {
//                    result = response.body();
//                } catch (Exception error) {
//                    Log.e("response", "Failed to parse");
//                }
//                if (result != null) {
//                    Log.d("response", "Data:\n" + result);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<GithubResponseModel>> call, Throwable t) {
//                Log.e("response", "onFailure called.");
//            }
//        });

        Observable<List<GithubResponseModel>> reposRequestRx = reposServices.listReposRx("osamaq");

        GithubResponseModel test = new GithubResponseModel();
        Disposable disposable = reposRequestRx
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(githubResponseModels ->
                        {
                            Log.d("response", "Inside the lambda");
                        }, throwable -> {

                            throwable.printStackTrace();
                        }

                );


    }

}