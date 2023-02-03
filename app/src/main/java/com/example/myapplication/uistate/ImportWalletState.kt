package com.example.myapplication.uistate

import com.example.myapplication.data.models.importaccountmodel.ImportAccountModel


sealed class ImportWalletState {
    object Empty : ImportWalletState()
    object Loading : ImportWalletState()
    class Loaded(val data: ImportAccountModel) : ImportWalletState()
    class Error(val message: String) : ImportWalletState()
}