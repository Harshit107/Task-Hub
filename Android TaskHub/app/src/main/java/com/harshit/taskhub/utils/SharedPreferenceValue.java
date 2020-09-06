package com.harshit.taskhub.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceValue {

    String valueUser;


    public static  void updatToken(Context context,String value)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("users",MODE_PRIVATE);
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.putString("token",value);
        edit.apply();

    }

    public static String getToken(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("users",MODE_PRIVATE);
        return sharedPreferences.getString("token","");

    }


//    public ArrayList<String> allFavImages(){
//        SharedPreferences sharedPreferences=context.getSharedPreferences("users",MODE_PRIVATE);
//        Map<String, ?> allEntries = sharedPreferences.getAll();
//        ArrayList<String> arrFav = new ArrayList<>();
//        Log.d("mapvalues", "At Console");
//
//        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
//            Log.d("map values", entry.getValue().toString());
//            if(entry.getKey().startsWith("fav") && !entry.getValue().equals("-1")){
//                arrFav.add(entry.getValue().toString());
//            }
//        }
//        return arrFav;
//    }

}
