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
        return  retrofitImageUpdate.build().create(ImageUpdateInterface::class.java)
    }



    @Singleton
    @Provides
    fun provideAllPost(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): AllPostI {
        return  retrofitBuilder.client(okHttpClient).build().create(AllPostI::class.java)
    }

    @Singleton
    @Provides
    fun provideProfileUpdate(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): ProfileUpdateI {
        return  retrofitBuilder.client(okHttpClient).build().create(ProfileUpdateI::class.java)
    }

    @Singleton
    @Provides
    fun provideProfile(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): ProfileI {
        return  retrofitBuilder.client(okHttpClient).build().create(ProfileI::class.java)
    }

    @Singleton
    @Provides
    fun provideNoOfFollowing(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): NoOfFollowingI {
        return  retrofitBuilder.client(okHttpClient).build().create(NoOfFollowingI::class.java)
    }

    @Singleton
    @Provides
    fun provideDirectReferralCount(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): DirectReferralCountI {
        return  retrofitBuilder.client(okHttpClient).build().create(DirectReferralCountI::class.java)
    }
    @Singleton
    @Provides
    fun provideTotalReferralCount(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): TotalReferralCountI {
        return  retrofitBuilder.client(okHttpClient).build().create(TotalReferralCountI::class.java)
    }
    @Singleton
    @Provides
    fun provideReferralReward(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): ReferralRewardI {
        return  retrofitBuilder.client(okHttpClient).build().create(ReferralRewardI::class.java)
    }
    @Singleton
    @Provides
    fun provideBonusReward(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): BonusRewardI {
        return  retrofitBuilder.client(okHttpClient).build().create(BonusRewardI::class.java)
    }
    @Singleton
    @Provides
    fun providePostReward(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient):PostRewardI {
        return  retrofitBuilder.client(okHttpClient).build().create(PostRewardI::class.java)
    }
    @Singleton
    @Provides
    fun provideLikeReward(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient): LikeRewardI {
        return  retrofitBuilder.client(okHttpClient).build().create(LikeRewardI::class.java)
    }
    @Singleton
    @Provides
    fun provideCommentReward(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient):CommentRewardI {
        return  retrofitBuilder.client(okHttpClient).build().create(CommentRewardI::class.java)
    }


}