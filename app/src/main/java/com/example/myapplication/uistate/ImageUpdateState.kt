package com.example.myapplication.uistate

import com.example.myapplication.data.models.imageupdatemodel.ImageUpdateModel


sealed class ImageUpdateState {
    object Empty : ImageUpdateState()
    object Loading : ImageUpdateState()
    class Loaded(val data: ImageUpdateModel) : ImageUpdateState()
    class Error(val message: String) : ImageUpdateState()
}