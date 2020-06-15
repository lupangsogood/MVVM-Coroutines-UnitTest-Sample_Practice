package com.lupin.myfirstmvvm.Data

import com.google.gson.annotations.SerializedName
import com.lupin.myfirstmvvm.Util.KEY_DATA
import com.lupin.myfirstmvvm.Util.KEY_MESSAGE
import com.lupin.myfirstmvvm.Util.KEY_STATUS
import java.net.HttpURLConnection

data class Result<out T> constructor(
    @SerializedName(KEY_STATUS)
    var statusCode: Int = -1,
    @SerializedName(KEY_MESSAGE)
    var message: String? = "",
    @SerializedName(KEY_DATA)
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T?): Result<T> = Result(HttpURLConnection.HTTP_OK, null, data)
        fun <T> error(statusCode:Int,message:String?): Result<T> = Result(statusCode,message,null)
    }

    fun isSuccessful(): Boolean = statusCode == HttpURLConnection.HTTP_OK

}
