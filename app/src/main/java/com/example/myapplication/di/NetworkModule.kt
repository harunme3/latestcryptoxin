package com.example.myapplication.di
import android.util.Log
import com.example.myapplication.data.datasource.remotedata.*
import com.example.myapplication.utilities.UrlConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideOkHttpClient(allInterceptor: AllInterceptor ):OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(allInterceptor).build()
    }


    @Singleton
    @Provides
    fun provideRetrofitBuilder():Retrofit.Builder{
       return Retrofit.Builder().baseUrl(UrlConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }
    var retrofitApiV1 = Retrofit.Builder()
        .baseUrl("http://128.199.18.36:8556/")
        .addConverterFactory(GsonConverterFactory.create())

    @Singleton
    @Provides
    fun provideFakerAPI(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): CreateWalletApiInterface {
        return  retrofitBuilder.client(okHttpClient).build().create(CreateWalletApiInterface::class.java)
    }


    @Singleton
    @Provides
    fun provideImportAccountAPI(retrofitBuilder: Retrofit.Builder): ImportWalletApiInterface {
        return  retrofitBuilder.build().create(ImportWalletApiInterface::class.java)
    }


    @Singleton
    @Provides
    fun provideGetAccount(retrofitBuilder: Retrofit.Builder): GetUserApiInterface {
        return  retrofitBuilder.build().create(GetUserApiInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideRegistration(retrofitBuilder: Retrofit.Builder): RegistrationInterface {
        return  retrofitBuilder.build().create(RegistrationInterface::class.java)
    }


    var retrofitImageUpdate = Retrofit.Builder()
        .baseUrl("http://128.199.18.36:6000/")
        .addConverterFactory(GsonConverterFactory.create())


    @Singleton
    @Provides
    fun provideImageUpdate(retrofitBuilder: Retrofit.Builder): ImageUpdateInterface {
        return  retrofitBuilder.build().create(ImageUpdateInterface::class.java)
    }

}