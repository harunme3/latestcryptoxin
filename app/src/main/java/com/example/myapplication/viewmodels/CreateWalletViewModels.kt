package com.example.myapplication.viewmodels
import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.data.models.createaccountmodel.CreateAccount
import com.example.myapplication.data.repository.CreateWalletApiRepo
import com.example.myapplication.uistate.CreateWalletState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateWalletViewModels @Inject constructor (private val createWalletApiRepo: CreateWalletApiRepo): ViewModel()  {

    private val createWalletStateFlow:MutableStateFlow<CreateWalletState>
            = MutableStateFlow(CreateWalletState.Empty)
    val _createWalletStateFlow:StateFlow<CreateWalletState> = createWalletStateFlow




    init {
        viewModelScope.launch {
            createWalletStateFlow.value = CreateWalletState.Loading
            createWalletApiRepo.getCreateWalletRepo()
                .catch { e->
                    createWalletStateFlow.value=CreateWalletState.Error(message = "Exception $e")
                }.collect {
                if (it.data!=null)
                {
                    val createAccountData=it.data as CreateAccount
                    createWalletStateFlow.value=CreateWalletState.Loaded(data =createAccountData)
                }
                }
        }
    }

    fun createWallet(walletEntity: WalletEntity) = viewModelScope.launch(Dispatchers.IO) {
         createWalletApiRepo.insertWallet(walletEntity)
    }

    fun deleteWallet(walletEntity: WalletEntity){
        viewModelScope.launch(Dispatchers.IO) {
            createWalletApiRepo.deleteWallet(walletEntity)
        }
    }
    fun getWallet(walletId:Int) = viewModelScope.launch(Dispatchers.IO) {
        createWalletApiRepo.getWallet(walletId = walletId)
    }

    //Room Database
     val getAllWallet: LiveData<List<WalletEntity>> = createWalletApiRepo.getAllWallet

}
