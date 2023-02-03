package com.example.myapplication.data.datasource.remotedata


import com.example.myapplication.data.bodymodel.ImportAccountBody
import com.example.myapplication.data.models.importaccountmodel.ImportAccountModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ImportWalletApiInterface {
    @POST("importWallet")
    suspend fun importWalletInterface(@Body importAccountBody: ImportAccountBody): Response<ImportAccountModel>
}