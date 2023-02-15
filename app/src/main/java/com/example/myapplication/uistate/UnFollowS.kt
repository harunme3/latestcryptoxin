package com.example.myapplication.uistate

import com.example.myapplication.data.models.userpostm.UserPostM


sealed class UnFollowS {
    object Empty : UnFollowS()
    object Loading : UnFollowS()
    class Loaded(val data: UserPostM) : UnFollowS()
    class Error(val message: String) : UnFollowS()
}