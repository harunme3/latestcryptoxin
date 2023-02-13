package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.common.Resource
import com.example.myapplication.data.bodymodel.GetUserModelBody
import com.example.myapplication.data.bodymodel.ImportAccountBody
import com.example.myapplication.data.datasource.remotedata.GetUserApiInterface
import com.example.myapplication.data.datasource.remotedata.ImportWalletApiInterface
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



class GetUserRepo @Inject
constructor(private val getUserApiInterface: GetUserApiInterface) {

    fun getUserApiRepo(getUserModelBody: GetUserModelBody) = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = getUserApiInterface.getUserInterface(getUserModelBody)
            Log.e("1111",apiResponse.toString())
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