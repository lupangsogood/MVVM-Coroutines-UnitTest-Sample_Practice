package com.lupin.myfirstmvvm.Data.remote

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.lupin.myfirstmvvm.Data.Result
import com.lupin.myfirstmvvm.Util.Extension.isJsonFormat
import com.lupin.myfirstmvvm.Util.ERR_CODE_NO_STATUS_CODE
import com.lupin.myfirstmvvm.Util.ERR_CODE_SOCKET_EXCEPTION
import com.lupin.myfirstmvvm.Util.KEY_MESSAGE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.BufferedSource
import retrofit2.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.nio.charset.Charset
import javax.net.ssl.HttpsURLConnection

open class  RemoteDataSource{
    suspend fun <T> call(job:T):Result<T> = withContext(Dispatchers.IO) {

        return@withContext try {
            Result.success(job)
        }catch (e:HttpException){
            e.printStackTrace()
            Result.error<T>(e.code(),getHttpExceptionMessage(e))
        }catch (e:SocketTimeoutException){
            e.printStackTrace()
            Result.error<T>(HttpsURLConnection.HTTP_CLIENT_TIMEOUT,e.message)
        }catch (e:SocketException){
            e.printStackTrace()
            Result.error<T>(ERR_CODE_SOCKET_EXCEPTION, e.message)
        }catch (throwable:Throwable){
            throwable.printStackTrace()
            Result.error<T>(ERR_CODE_NO_STATUS_CODE,throwable.message)
        }
    }

    fun getHttpExceptionMessage(exception: HttpException): String {
        if (exception.response()?.errorBody()?.contentType() != null) {
            exception.response()?.errorBody()?.also { errorBody ->

                val source: BufferedSource = errorBody.source()
                source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
                val charset: Charset = errorBody.contentType()!!.charset(Charset.forName("UTF-8"))!!
                val stringBody = source.buffer().clone().readString(charset)

                if (stringBody.isJsonFormat()) {
                    val jsonObject = Gson().fromJson(stringBody, JsonElement::class.java).asJsonObject
                    if (jsonObject.has(KEY_MESSAGE)) {
                        return jsonObject.get(KEY_MESSAGE).asString
                    }
                }
            }
        }
        return exception.message()
    }
}