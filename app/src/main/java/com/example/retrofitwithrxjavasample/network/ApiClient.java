package com.example.retrofitwithrxjavasample.network;

import android.content.Context;
import android.text.TextUtils;

import com.example.retrofitwithrxjavasample.app.Const;
import com.example.retrofitwithrxjavasample.utils.PrefUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient  {

    private static Retrofit retrofit = null ;
    private static OkHttpClient okHttpClient;
    private static int REQUEST_TIMEOUT =60;

    public static Retrofit getclient(Context context){
        if(okHttpClient==null){
            initOkHttp(context);
        }

      if(retrofit ==null){
          retrofit=new Retrofit.Builder()
                        .baseUrl(Const.BASE_URL)
                        .client(okHttpClient)
                         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                         .addConverterFactory(GsonConverterFactory.create())
                         .build();

      }
    return  retrofit;
    }

    public static void initOkHttp (final Context context){

        OkHttpClient.Builder httpclient = new OkHttpClient.Builder()
                .connectTimeout(REQUEST_TIMEOUT , TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT,TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpclient.addInterceptor(interceptor);
        httpclient.addInterceptor( new Interceptor(){

            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json");

                if (!TextUtils.isEmpty(PrefUtil.getApiKey(context))) {
                    requestBuilder.addHeader("Authorization", PrefUtil.getApiKey(context));
                }

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        okHttpClient = httpclient.build();
    }

            }






