package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.bodymodel.ProfileUpdateB
import com.example.myapplication.data.repository.ProfileUpdateR
import com.example.myapplication.uistate.ProfileUpdateS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileUpdateVM  @Inject constructor (private val profileUpdateR: ProfileUpdateR): ViewModel()  {

    private val setProfileUpdateStateFlow: MutableStateFlow<ProfileUpdateS>
            = MutableStateFlow(ProfileUpdateS.Empty)
    val _setProfileUpdateStateFlow: StateFlow<ProfileUpdateS> = setProfileUpdateStateFlow


     fun setProfileUpdate(profileUpdateB: ProfileUpdateB) {


        viewModelScope.launch {

            setProfileUpdateStateFlow.value = ProfileUpdateS.Loading

            profileUpdateR.setProfileUpdateR(profileUpdateB
            ).catch { e->
                setProfileUpdateStateFlow.value= ProfileUpdateS.Error(message = "Exception $e")
            }.collect {
                if (it.data!=null)
                {

                    val getAllPostData=it.data
                    setProfileUpdateStateFlow.value= ProfileUpdateS.Loaded(data =getAllPostData)
                }
            }
        }
    }

}