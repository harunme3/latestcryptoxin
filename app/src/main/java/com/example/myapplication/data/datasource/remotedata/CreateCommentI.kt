package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.bodymodel.CreateCommentBody
import com.example.myapplication.data.models.allpostm.AllPostM
import com.example.myapplication.data.models.createcommentm.CreateCommentM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface CreateCommentI {

    @POST("createComment")
    suspend fun getCreateCommentI(@Body createCommentBody: CreateCommentBody): Response<CreateCommentM>
}