package com.example.myapplication.uistate

import com.example.myapplication.data.models.profileupdatem.ProfileUpdateM


sealed class ProfileUpdateS {
    object Empty : ProfileUpdateS()
    object Loading : ProfileUpdateS()
    class Loaded(val data: ProfileUpdateM) : ProfileUpdateS()
    class Error(val message: String) : ProfileUpdateS()
}