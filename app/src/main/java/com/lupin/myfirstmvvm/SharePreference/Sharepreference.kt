package com.lupin.myfirstmvvm.SharePreference

import android.content.Context
import android.content.SharedPreferences

class Sharepreference(context: Context) {

    private var shared: SharedPreferences = context.getSharedPreferences(
        "MVVM_PREFS",
        Context.MODE_PRIVATE
    )
    private val shareEditor = shared.edit()

    fun getString(K:String):String{
        return shared.getString(K,"No Value In SharePreference") ?: "SharePreference Not Found"
    }

    fun putString(K:String,V:String) {
            shareEditor.putString(K, V).apply()
    }

    fun removeAll(){
        shareEditor.clear().apply()
    }
}