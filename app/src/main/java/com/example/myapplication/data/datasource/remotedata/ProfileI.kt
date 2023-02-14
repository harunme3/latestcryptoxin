package com.example.myapplication.data.datasource.remotedata


import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.models.profilem.ProfileM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ProfileI {

    @POST("getprofiles")
    suspend fun getProfileI(@Body addressPrivateKeyBody: AddressPrivateKeyBody): Response<ProfileM>
}