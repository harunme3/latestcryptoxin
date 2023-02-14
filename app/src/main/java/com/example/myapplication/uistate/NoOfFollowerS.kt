package com.example.myapplication.uistate

import com.example.myapplication.data.models.nooffollower.NoOfFollowerM


sealed class NoOfFollowerS {
    object Empty : NoOfFollowerS()
    object Loading : NoOfFollowerS()
    class Loaded(val data: NoOfFollowerM) : NoOfFollowerS()
    class Error(val message: String) : NoOfFollowerS()
}