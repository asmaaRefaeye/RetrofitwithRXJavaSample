package com.example.retrofitwithrxjavasample.network.model;

public class Note extends BaseResponse {

    int id ;
    String node ;
    String timestamp;

    public int getId() {
        return id;
    }

    public String getNote() {
        return node;
    }

    public void setNote(String node) {
        this.node = node;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
