package com.example.learn.data.service;

import android.database.Observable;

import com.example.learn.data.dao.types.GithubResponseModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Step 1: In RestProvider, build the service with the base URL. Declare method which returns the service.
 * Step 2: In ReposService interface, declare the type and URL for the HTTP request and function which will call it.
 * Step 3: In the FetchDataPresenter, make the API call and handle the response.
 */
public interface ReposService {

    // The response model objects are generated using jsonschema2pojo.org
    @GET("users/{user}/repos")
    Call <List<GithubResponseModel>> listRepos(@Path("user") String user);
}

