package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.bodymodel.RegisterBody
import com.example.myapplication.data.models.registrationmodel.RegistrationModel
import com.example.myapplication.data.repository.RegistrationRepo
import com.example.myapplication.uistate.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel  @Inject constructor (private val registrationRepo: RegistrationRepo): ViewModel()  {

    private val registrationStateFlow: MutableStateFlow<RegisterState>
            = MutableStateFlow(RegisterState.Empty)
    val _registrationStateFlow: StateFlow<RegisterState> = registrationStateFlow

    fun registrationCall(myAddress:String,privateKey:String,referralCode:String) {

        val body = RegisterBody(myAddress=myAddress,privateKey=privateKey,referralcode=referralCode)
        viewModelScope.launch {

            registrationStateFlow.value = RegisterState.Loading

            registrationRepo.registrationRepoCall(
                registerBody = body
            ).catch { e->
                registrationStateFlow.value= RegisterState.Error(message = "Exception $e")
            }.collect {
                if (it.data!=null)
                {
                    val registerData=it.data as RegistrationModel
                    registrationStateFlow.value= RegisterState.Loaded(data =registerData)
                }
            }
        }
    }

}