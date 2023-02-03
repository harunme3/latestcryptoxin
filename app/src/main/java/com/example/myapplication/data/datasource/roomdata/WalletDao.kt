package com.example.myapplication.data.datasource.roomdata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.utilities.DataBaseConstants

@Dao
interface WalletDao{
    @Insert()
    suspend fun insert(walletEntity: WalletEntity)

    @Delete
    suspend fun deleteNote(walletEntity: WalletEntity)


    @Query("SELECT * FROM ${DataBaseConstants.WALLET_TABLE} WHERE walletId LIKE :walletId")
    suspend fun getWallet(walletId : Int) : WalletEntity

//why we not marked it suspend because live data automatically run it in background thread or can say marked it suspend automatically
    @Query("SELECT * FROM ${DataBaseConstants.WALLET_TABLE}")
    fun  getWalletList() :LiveData<List<WalletEntity>>





}

