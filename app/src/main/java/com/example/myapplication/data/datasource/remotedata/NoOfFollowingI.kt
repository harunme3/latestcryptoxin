package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.models.nooffollowing.NoOfFollowingM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NoOfFollowingI {
    @POST("getNoOffFollowing")
    suspend fun getNoOfFollowingI(@Body addressPrivateKeyBody: AddressPrivateKeyBody): Response<NoOfFollowingM>
}