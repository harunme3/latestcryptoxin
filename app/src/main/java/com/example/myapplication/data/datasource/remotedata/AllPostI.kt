package com.example.myapplication.data.datasource.remotedata


import com.example.myapplication.data.models.allpostm.AllPostM
import retrofit2.Response
import retrofit2.http.POST

interface AllPostI {

    @POST("getallPost")
    suspend fun getAllPostI(): Response<AllPostM>
}