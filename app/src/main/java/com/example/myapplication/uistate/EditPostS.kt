package com.example.myapplication.uistate

import com.example.myapplication.data.models.userpostm.UserPostM


sealed class EditPostS {
    object Empty : EditPostS()
    object Loading : EditPostS()
    class Loaded(val data: UserPostM) : EditPostS()
    class Error(val message: String) : EditPostS()
}