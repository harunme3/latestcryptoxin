package com.example.myapplication.uistate

import com.example.myapplication.data.models.getuser.GetUserModel
import com.example.myapplication.data.models.importaccountmodel.ImportAccountModel



sealed class GetUserState {
    object Empty : GetUserState()
    object Loading : GetUserState()
    class Loaded(val data: GetUserModel) : GetUserState()
    class Error(val message: String) : GetUserState()
}