package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.bodymodel.SpecificPostBody
import com.example.myapplication.data.models.allpostm.AllPostM
import com.example.myapplication.data.models.specificpostm.SpecificPostM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface SpecificPostI {

    @POST("getpostbyid")
    suspend fun getSpecificPostI(@Body specificPostBody: SpecificPostBody): Response<SpecificPostM>
}