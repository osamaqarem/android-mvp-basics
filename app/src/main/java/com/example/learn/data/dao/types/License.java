
package com.example.learn.data.dao.types;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

@Entity
public class License {

    @Generated
    @Key
    int id;
    @SerializedName("key")
    @Expose
    public String key;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("spdx_id")
    @Expose
    public String spdxId;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("node_id")
    @Expose
    public String nodeId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpdxId() {
        return spdxId;
    }

    public void setSpdxId(String spdxId) {
        this.spdxId = spdxId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

}
