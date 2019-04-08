package com.example.retrofitwithrxjavasample.network;

import com.example.retrofitwithrxjavasample.network.model.Note;
import com.example.retrofitwithrxjavasample.network.model.User;

import org.w3c.dom.Node;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    // Register new user
    @FormUrlEncoded
    @POST("notes/user/register")
    Single<User> register(@Field("device_id") String deviceId);

    //creat new node
    @FormUrlEncoded
    @POST("notes/new")
    Single<Note> creatNotes(@Field("note") String note);

    //fetch all notes
    @FormUrlEncoded
    @GET("notes/all")
    Single<List<Note>> fetchAllNotes();


    //update single note
    @FormUrlEncoded
    @PUT("notes /{id}")
    Completable updateNote(@Path("id") int noteId ,@Field("note") String note);




    //delete notes
    @DELETE("notes/{id}")
    Completable deleteNote(@Path("id") int noteId);


}
