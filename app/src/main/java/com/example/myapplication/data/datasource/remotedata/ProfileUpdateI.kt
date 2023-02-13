package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.ProfileUpdateB
import com.example.myapplication.data.models.profileupdatem.ProfileUpdateM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ProfileUpdateI {

    @POST("profileupdate")
    suspend fun setProfileUpdateI(@Body profileUpdateB: ProfileUpdateB): Response<ProfileUpdateM>
}