package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.RegisterBody
import com.example.myapplication.data.models.registrationmodel.RegistrationModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface RegistrationInterface {
    @POST("ragistration")
    suspend fun registerUserInterface(@Body registerBody: RegisterBody): Response<RegistrationModel>
}