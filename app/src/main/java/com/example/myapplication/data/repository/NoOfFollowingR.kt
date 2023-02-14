package com.example.myapplication.data.repository

import com.example.myapplication.common.Resource
import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.datasource.remotedata.NoOfFollowingI
import com.example.myapplication.data.datasource.remotedata.ProfileI
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class NoOfFollowingR @Inject constructor(private val noOfFollowingI: NoOfFollowingI) {

    fun getNoOfFollowingR(addressPrivateKeyBody: AddressPrivateKeyBody) = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = noOfFollowingI.getNoOfFollowingI(addressPrivateKeyBody)
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