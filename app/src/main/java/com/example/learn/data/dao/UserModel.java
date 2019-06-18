package com.example.learn.data.dao;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Index;
import io.requery.Key;

@Entity
public abstract class UserModel {

    @Key
    @Generated
    int id;

    // The value is the default value when no default value is provided in the declaration.
    @Index(value = "default_saved_name")
    String name = "default name";

}
