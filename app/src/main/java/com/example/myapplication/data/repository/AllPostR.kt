package com.example.myapplication.data.repository

import com.example.myapplication.common.Resource
import com.example.myapplication.data.datasource.remotedata.AllPostI
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllPostR @Inject
constructor(private val allPostI: AllPostI) {
    fun getAllPostR() = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = allPostI.getAllPostI()
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