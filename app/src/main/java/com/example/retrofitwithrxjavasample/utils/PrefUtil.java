package com.example.retrofitwithrxjavasample.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtil {


    public PrefUtil(){

    }

    private static SharedPreferences getsharedPrefrences(Context context){
       return context.getSharedPreferences("App_pref",Context.MODE_PRIVATE);
    }

    public static void storeApiKey(Context  context,String apikey){
        SharedPreferences.Editor editor = getsharedPrefrences(context).edit();
        editor.putString("API_Key" ,apikey);
        editor.commit();
    }

    public static String getApiKey(Context context){
        return getsharedPrefrences(context).getString("API_KEY",null);
    }
}
