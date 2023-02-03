package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.GetUserModelBody
import com.example.myapplication.data.models.getuser.GetUserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface GetUserApiInterface {
    @POST("getUser")
    suspend fun getUserInterface(@Body getUserModelBody: GetUserModelBody): Response<GetUserModel>
}