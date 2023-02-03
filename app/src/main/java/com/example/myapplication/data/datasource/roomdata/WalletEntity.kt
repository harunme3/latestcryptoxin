package com.example.myapplication.data.datasource.roomdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.utilities.DataBaseConstants

@Entity(tableName = DataBaseConstants.WALLET_TABLE)
data class WalletEntity(
    @PrimaryKey(autoGenerate = true)
    val walletId :Int?,
    val privateKey: String,
    val mnemonicPhrase: String?=null,
    val address:String)

