package com.example.myapplication.uistate

import com.example.myapplication.data.datasource.roomdata.WalletEntity


sealed class WalletS {
    object Empty : WalletS()
    object Loading : WalletS()
    class Loaded(val data: List<WalletEntity>) : WalletS()
    class Error(val message: String) : WalletS()
}