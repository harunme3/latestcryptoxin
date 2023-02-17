package com.example.myapplication.data.datasource.remotedata

import com.example.myapplication.data.bodymodel.AddressPrivateKeyBody
import com.example.myapplication.data.bodymodel.CommentsBody
import com.example.myapplication.data.models.allpostm.AllPostM
import com.example.myapplication.data.models.commentsm.CommentsM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST



interface CommentsI {

    @POST("getComments")
    suspend fun getCommentsI(@Body commentsBody: CommentsBody): Response<CommentsM>
}