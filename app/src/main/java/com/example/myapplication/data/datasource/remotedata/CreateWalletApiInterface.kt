package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.models.createaccountmodel.CreateAccount
import retrofit2.Response
import retrofit2.http.POST

interface CreateWalletApiInterface {
    @POST("createAddress")
    suspend fun getWalletDetailInterface(): Response<CreateAccount>
}