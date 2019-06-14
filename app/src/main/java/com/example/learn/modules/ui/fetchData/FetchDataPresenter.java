package com.example.learn.modules.ui.fetchData;

import android.util.Log;

import com.example.learn.data.service.ReposService;
import com.example.learn.modules.base.mvp.presenter.BasePresenter;
import com.example.learn.provider.rest.RestProvider;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FetchDataPresenter extends BasePresenter<FetchDataMvp.View> implements FetchDataMvp.Presenter {

    @Override
    public void fetchRepos() {
        // Get the retrofit object with the baseURL
        // Use retrofit to create the API
        Retrofit retrofit = RestProvider.getRetrofit();

        ReposService reposServices = retrofit.create(ReposService.class);

        Call<ResponseBody> reposRequest = reposServices.listRepos("osamaq");

        // Async queue the request. Callback to handle the result.
        reposRequest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException error) {
                    Log.e("response", "Failed to parse");
                }
                if (result != null) {
                    Log.d("response", "Data:\n" + result);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("response", "onFailure called.");
            }
        });
    }

}
