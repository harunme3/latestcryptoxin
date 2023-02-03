package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.common.Resource
import com.example.myapplication.data.datasource.remotedata.ImageUpdateInterface
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject



class ImageUpdateRepo @Inject
constructor(private val imageUpdateInterface: ImageUpdateInterface) {

    fun getImageUpdateRepo(file: MultipartBody.Part, myAddress: RequestBody,
                           privateKey:RequestBody,
                           type:RequestBody,
                           _content:RequestBody,
                           _hashtag:RequestBody) = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = imageUpdateInterface.getImageUpdate(
                file = file,
                myAddress = myAddress,
                privateKey = privateKey,
                type = type,
                _content=_content,
                _hashtag=_hashtag
            )
            Log.d("1111",apiResponse.toString())
            if (apiResponse.isSuccessful) {

                val result = apiResponse.body()
                emit(Resource.Success(result))
            } else {
                emit(Resource.Error("Api is unsuccessful"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("IO Exception: ${e.message}"))
        }
    }
}