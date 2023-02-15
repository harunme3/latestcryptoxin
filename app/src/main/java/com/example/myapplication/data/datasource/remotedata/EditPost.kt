package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.EditPostBody
import com.example.myapplication.data.models.userpostm.UserPostM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface EditPostI {

    @POST("editPost")
    suspend fun getEditPostI(@Body editPostBody: EditPostBody): Response<UserPostM>
}