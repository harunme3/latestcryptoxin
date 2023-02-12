package com.example.myapplication.uistate

import com.example.myapplication.data.models.allpostm.ALLPOSTM

sealed class AllPostS {
    object Empty : AllPostS()
    object Loading : AllPostS()
    class Loaded(val data: ALLPOSTM) : AllPostS()
    class Error(val message: String) : AllPostS()
}