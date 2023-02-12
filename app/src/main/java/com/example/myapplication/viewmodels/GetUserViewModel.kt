package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.bodymodel.GetUserModelBody
import com.example.myapplication.data.models.getuser.GetUserModel
import com.example.myapplication.data.repository.GetUserRepo
import com.example.myapplication.uistate.GetUserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GetUserViewModel  @Inject constructor (private val getUserRepo: GetUserRepo): ViewModel()  {

    private val getUserStateFlow: MutableStateFlow<GetUserState>
            = MutableStateFlow(GetUserState.Empty)
    val _getUserStateFlow: StateFlow<GetUserState> = getUserStateFlow

    fun getUserCall(myAddress:String) {

        val body = GetUserModelBody(myAddress =myAddress)
        viewModelScope.launch {

            getUserStateFlow.value = GetUserState.Loading

            getUserRepo.getUserApiRepo(
                getUserModelBody = body
            ).catch { e->
                getUserStateFlow.value= GetUserState.Error(message = "Exception $e")
            }.collect {
                if (it.data!=null)
                {

                    val getUserData=it.data as GetUserModel
                    getUserStateFlow.value= GetUserState.Loaded(data =getUserData)
                }
            }
        }
    }

}