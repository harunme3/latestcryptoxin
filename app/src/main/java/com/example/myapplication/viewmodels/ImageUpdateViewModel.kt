package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.bodymodel.GetUserModelBody
import com.example.myapplication.data.models.getuser.GetUserModel
import com.example.myapplication.data.models.imageupdatemodel.ImageUpdateModel
import com.example.myapplication.data.repository.GetUserRepo
import com.example.myapplication.data.repository.ImageUpdateRepo
import com.example.myapplication.uistate.GetUserState
import com.example.myapplication.uistate.ImageUpdateState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject


@HiltViewModel
class ImageUpdateViewModel  @Inject constructor (private val imageUpdateRepo: ImageUpdateRepo): ViewModel()  {



    private val getImageUpdateStateFlow: MutableStateFlow<ImageUpdateState>
            = MutableStateFlow(ImageUpdateState.Empty)
    val _getUserStateFlow: StateFlow<ImageUpdateState> = getImageUpdateStateFlow

    fun getImageUpdateCall(file: MultipartBody.Part, myAddress: RequestBody, privateKey:RequestBody, type:RequestBody) {

        viewModelScope.launch {

            getImageUpdateStateFlow.value = ImageUpdateState.Loading

            imageUpdateRepo.getImageUpdateRepo(file,myAddress,privateKey,type)
                .catch { e->
                getImageUpdateStateFlow.value= ImageUpdateState.Error(message = "Exception $e")
            }.collect {
                if (it.data!=null)
                {

                    val imageUpdateData=it.data as ImageUpdateModel
                    getImageUpdateStateFlow.value= ImageUpdateState.Loaded(data =imageUpdateData)
                }
            }
        }
    }

}