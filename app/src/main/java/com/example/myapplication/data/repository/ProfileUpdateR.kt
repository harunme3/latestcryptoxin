package com.example.myapplication.data.repository

import com.example.myapplication.common.Resource
import com.example.myapplication.data.bodymodel.ProfileUpdateBody
import com.example.myapplication.data.datasource.remotedata.ProfileUpdateI
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ProfileUpdateR @Inject
constructor(private val profileUpdateI: ProfileUpdateI) {
    fun setProfileUpdateR(profileUpdateBody: ProfileUpdateBody) = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = profileUpdateI.setProfileUpdateI(profileUpdateBody)
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