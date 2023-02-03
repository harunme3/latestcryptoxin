package com.example.myapplication.data.datasource.remotedata



import com.example.myapplication.data.bodymodel.GetUserModelBody
import com.example.myapplication.data.models.getuser.GetUserModel
import com.example.myapplication.data.models.imageupdatemodel.ImageUpdateModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface TestInterface {

    @Multipart
    @POST("upload")
    fun getImageUpdate(
        @Part file:MultipartBody.Part,
        @Part("myAddress") myAddress: RequestBody,
        @Part("privateKey") privateKey: RequestBody,
        @Part("type") type: RequestBody,
        @Part("_content") _content: RequestBody,
        @Part("_hashtag") _hashtag: RequestBody
    ): Call<ImageUpdateModel>

}