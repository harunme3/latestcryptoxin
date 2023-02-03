package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.common.Resource
import com.example.myapplication.data.bodymodel.GetUserModelBody
import com.example.myapplication.data.bodymodel.RegisterBody
import com.example.myapplication.data.datasource.remotedata.GetUserApiInterface
import com.example.myapplication.data.datasource.remotedata.RegistrationInterface
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class RegistrationRepo @Inject
constructor(private val registrationInterface: RegistrationInterface) {

    fun registrationRepoCall(registerBody: RegisterBody) = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = registrationInterface.registerUserInterface(registerBody)
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