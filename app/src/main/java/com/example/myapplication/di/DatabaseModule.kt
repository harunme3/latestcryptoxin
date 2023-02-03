

package com.example.myapplication.di
import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.datasource.roomdata.WalletDatabase
import com.example.myapplication.utilities.DataBaseConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context)
         =Room. databaseBuilder(context,WalletDatabase::class.java,DataBaseConstants.WALLET_DATABASE).build()


    @Singleton
    @Provides
    fun provideYourDao(walletDatabase: WalletDatabase) = walletDatabase.walletDao()
}