package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.models.nooffollower.NoOfFollowerM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NoOfFollowerI {

    @POST("getNoOffFollowers")
    suspend fun getNoOfFollowerI(@Body addressPrivateKeyBody: AddressPrivateKeyBody): Response<NoOfFollowerM>
}