package com.example.myapplication.uistate

import com.example.myapplication.data.models.signupbonusm.SignupBonusM


sealed class SignupBonusS {
    object Empty : SignupBonusS()
    object Loading : SignupBonusS()
    class Loaded(val data: SignupBonusM) : SignupBonusS()
    class Error(val message: String) : SignupBonusS()
}