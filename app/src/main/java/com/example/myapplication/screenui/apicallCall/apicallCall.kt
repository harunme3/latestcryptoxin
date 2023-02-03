package com.example.myapplication.screenui.apicallCall

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import com.example.myapplication.data.datasource.remotedata.TestInterface
import com.example.myapplication.data.models.imageupdatemodel.ImageUpdateModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apicallCall {

    private fun postDataUsingRetrofit(
        ctx: Context,
        result: MutableState<String>,
        file: MultipartBody.Part,
        myAddress: RequestBody,
        privateKey: RequestBody,
        type: RequestBody,
        _content: RequestBody,
        _hashtag: RequestBody
    ) {
        var url = "http://128.199.18.36:6000/"
        // on below line we are creating a retrofit
        // builder and passing our base url
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            // as we are sending data in json format so
            // we have to add Gson converter factory
            .addConverterFactory(GsonConverterFactory.create())
            // at last we are building our retrofit builder.
            .build()
        // below the line is to create an instance for our retrofit api class.
        val retrofitAPI = retrofit.create(TestInterface::class.java)
        // passing data from our text fields to our model class.

        // calling a method to create an update and passing our model class.
        val call: Call<ImageUpdateModel> = retrofitAPI.getImageUpdate(
            file = file,
            myAddress = myAddress,
            privateKey = privateKey,
            type = type,
            _content=_content,
            _hashtag=_hashtag)
        // on below line we are executing our method.
        call!!.enqueue(object : Callback<ImageUpdateModel?> {
            override fun onResponse(call: Call<ImageUpdateModel?>?, response: Response<ImageUpdateModel?>) {
                // this method is called when we get response from our api.
                Toast.makeText(ctx, "Data posted to API", Toast.LENGTH_SHORT).show()
                // we are getting a response from our body and
                // passing it to our model class.
                val model: ImageUpdateModel? = response.body()
                // on below line we are getting our data from model class
                // and adding it to our string.
                val resp =
                    "Response Code : " + response.code() + "\n" + "User Name : " + model!!.msg + "\n" + "Job : " + model!!.msg
                // below line we are setting our string to our response.
                result.value = resp
            }

            override fun onFailure(call: Call<ImageUpdateModel?>?, t: Throwable) {
                // we get error response from API.
                result.value = "Error found is : " + t.message
            }
        })

    }
}