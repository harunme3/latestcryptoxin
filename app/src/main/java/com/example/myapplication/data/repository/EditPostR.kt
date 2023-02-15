package com.example.myapplication.data.repository

import com.example.myapplication.common.Resource
import com.example.myapplication.data.bodymodel.EditPostBody
import com.example.myapplication.data.bodymodel.FollowBody
import com.example.myapplication.data.datasource.remotedata.EditPostI
import com.example.myapplication.data.datasource.remotedata.FollowI
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class EditPostR @Inject
constructor(private val editPostI: EditPostI) {

    fun getEditPostR(editPostBody: EditPostBody) = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = editPostI.getEditPostI(editPostBody)
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