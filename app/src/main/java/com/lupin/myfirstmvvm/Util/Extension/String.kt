package com.lupin.myfirstmvvm.Util.Extension

import android.util.Patterns
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun String.isAllDigit() = this.matches("[0-9]+".toRegex())

fun String.isEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isPhoneNumber() = Patterns.PHONE.matcher(this).matches()

fun String.isUrl() = Patterns.WEB_URL.matcher(this).matches()

fun String.isIpAddress() = Patterns.IP_ADDRESS.matcher(this).matches()

fun String.isJsonFormat(): Boolean {
    try {
        JSONObject(this)
    } catch (ex: JSONException) {
        // edited, to include @Arthur's comment
        // e.g. in case JSONArray is valid as well...
        try {
            JSONArray(this)
        } catch (ex1: JSONException) {
            return false
        }
    }
    return true
}