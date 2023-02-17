package com.example.myapplication.screenui.createImport

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.data.bodymodel.ProfileUpdateBody
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.navigation.Graph
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.uistate.ProfileUpdateS
import com.example.myapplication.viewmodels.ProfileUpdateVM
import com.example.myapplication.viewmodels.WalletVM

@Composable
fun MandatoryDetails(
     navController: NavController,
     mnemonic: String,
     privateKey: String,
     address: String,
     referralCode: String,
     profileUpdateVM: ProfileUpdateVM= hiltViewModel(),
     walletVM: WalletVM = hiltViewModel()
){
    val state = profileUpdateVM._setProfileUpdateStateFlow.collectAsState()
    val context=LocalContext.current
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    var name by remember {
        mutableStateOf("")
    }

    var username by remember {
        mutableStateOf("")
    }


    Log.e("1111",state.value.toString())

    if (state.value is ProfileUpdateS.Loaded){
        LaunchedEffect(key1 ="key1"){
           walletVM.createWallet(WalletEntity(null,mnemonicPhrase=mnemonic,privateKey=privateKey,address=address))
        navController.navigate(Graph.DASHBOARD)
        }

    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


       TextField(value = name, onValueChange = {
            name = it
        })

       TextField(value = username, onValueChange = {
            username = it
        })



        Button(
            onClick = {


                profileUpdateVM.setProfileUpdate(
                    name = name ,
                    UserName =username ,
                    email = "" ,
                    organization = "" ,
                    profileTag = "" ,
                    designation = "" ,
                    dob = "" ,
                    otherDetails = "" ,
                    Profileimgg = "" ,
                    backgroundimgg = ""
                )


            },
            modifier = Modifier
                .padding(30.dp)
                .clip(RoundedCornerShape(topEnd = 36.dp , bottomStart = 36.dp ,)),
            colors = ButtonDefaults.buttonColors(backgroundColor = chonolulublue)
        )
        {

            Text(text = "Next",
                style = TextStyle(
                    color = cwhite,
                    fontSize = 18.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
            )


        }
    }
}