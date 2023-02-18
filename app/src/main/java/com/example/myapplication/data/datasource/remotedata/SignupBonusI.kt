package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.models.signupbonusm.SignupBonusM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupBonusI {

    @POST("singupbonace")
    suspend fun getSignupBonusI(@Body addressPrivateKeyBody: AddressPrivateKeyBody): Response<SignupBonusM>
}