package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.common.Resource
import com.example.myapplication.data.bodymodel.ImportAccountBody
import com.example.myapplication.data.datasource.remotedata.ImportWalletApiInterface
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ImportWalletRepo @Inject
constructor(private val importWalletApiInterface: ImportWalletApiInterface) {

    fun getImportWalletRepo(importAccountBody: ImportAccountBody) = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = importWalletApiInterface.importWalletInterface(importAccountBody)

            if (apiResponse.isSuccessful) {

                val result = apiResponse.body()
                emit(Resource.Success(result))
            } else {
                emit(Resource.Error("Api is unsuccessful"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("IO Exception: ${e.message}"))
        }
    }
}