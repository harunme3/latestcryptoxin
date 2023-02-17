package com.example.myapplication.data.datasource.remotedata


import com.example.myapplication.data.bodymodel.ProfileUpdateBody
import com.example.myapplication.data.models.profileupdatem.ProfileUpdateM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ProfileUpdateI {

    @POST("profileupdate")
    suspend fun setProfileUpdateI(@Body profileUpdateBody: ProfileUpdateBody): Response<ProfileUpdateM>
}