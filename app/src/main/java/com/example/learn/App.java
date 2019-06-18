package com.example.learn;

import android.app.Application;
import android.util.Log;

import com.example.learn.data.Models;
import com.example.learn.data.dao.UserModelEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.meta.EntityModel;
import io.requery.reactivex.ReactiveEntityStore;
import io.requery.reactivex.ReactiveSupport;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;
import io.requery.sql.SchemaModifier;
import io.requery.sql.TableCreationMode;

public class App extends Application {
    private static final EntityModel DB_ENTITY_MODEL = Models.DEFAULT;
    private static final String DB = "DB";
    private static final int DB_VERSION = 4;
    private ReactiveEntityStore<Persistable> dataStore;
    Disposable mDisposable;

    private static App instance;

    public ReactiveEntityStore<Persistable> getDataSource() {
        if (dataStore == null) {
            // override onUpgrade to handle migrating to a new version
            DatabaseSource source = new DatabaseSource(this, DB_ENTITY_MODEL, DB, DB_VERSION);

            if (BuildConfig.DEBUG) {
                // use this in development mode to drop and recreate the tables on every upgrade
                source.setTableCreationMode(TableCreationMode.DROP_CREATE);
            }
            Configuration configuration = source.getConfiguration();

            // Drop the tables
            SchemaModifier modifier = new SchemaModifier(configuration);
            modifier.createTables(TableCreationMode.DROP_CREATE);

            // Create a data store with the configuration and make it compatible wit RxJava
            dataStore = ReactiveSupport.toReactiveStore(
                    new EntityDataStore<Persistable>(configuration));
        }
        return dataStore;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        final UserModelEntity user = new UserModelEntity();

        Log.d("db", "Old Name: " + user.getName());


        user.setName("Osama");


        mDisposable = getDataSource()
                .insert(user)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userModelEntity -> Log.d("db", "User inserted. Name: " + userModelEntity.getName() + " ID: " + userModelEntity.getId()));


    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        // When the app is killed.
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

    public static App instance() {
        return instance;
    }
}
