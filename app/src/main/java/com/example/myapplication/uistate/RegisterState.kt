package com.example.myapplication.uistate

import com.example.myapplication.data.models.registrationmodel.RegistrationModel


sealed class RegisterState {
    object Empty : RegisterState()
    object Loading : RegisterState()
    class Loaded(val data: RegistrationModel) : RegisterState()
    class Error(val message: String) : RegisterState()
}