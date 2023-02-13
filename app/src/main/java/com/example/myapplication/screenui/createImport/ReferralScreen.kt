package com.example.myapplication.screenui.createImport

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.navigation.Graph
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.cblack
import com.example.myapplication.ui.theme.cgraylight
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.uistate.RegisterState
import com.example.myapplication.viewmodels.CreateWalletViewModels
import com.example.myapplication.viewmodels.RegisterViewModel
import com.example.myapplication.viewmodels.WalletVM

@Composable
fun ReferralScreen(
    navController: NavController,
     mnemonic: String,
    privateKey: String,
    address: String,
    registerViewModel: RegisterViewModel = hiltViewModel(),
    walletVM: WalletVM = hiltViewModel()
){
    val state = registerViewModel._registrationStateFlow.collectAsState()
    var inputTextReferral by remember {
        mutableStateOf("")
    }


    if (state.value is RegisterState.Loaded){
        LaunchedEffect(key1 ="key1"){
            Log.e("1111",state.value.toString())
            navController.navigate(Screens.MandatoryDetails.route+"/${mnemonic}/${privateKey}/${address}/${inputTextReferral}")
        }

    }




    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
        ) {

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {

            Text(text = "Referral Code", style = TextStyle(fontSize = 24.sp))
            Box(modifier = Modifier
                .padding(2.dp)
                .clickable {
                    inputTextReferral = "1"
                    registerViewModel.registrationCall(
                        myAddress = address ,
                        privateKey = privateKey ,
                        referralCode = "1"
                    )


                })
            {
                Text(
                    text = "skip",
                    modifier = Modifier
                        .background(
                            color = cgraylight ,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 8.dp , horizontal = 16.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
          Box() {
                BasicTextField(
                    modifier= Modifier
                        .border(2.dp , cblack)
                        .height(50.dp)
                        .fillMaxWidth(),
                    value = inputTextReferral,
                    onValueChange ={
                        inputTextReferral=it
            } )
}



    Button(
        onClick = {
            registerViewModel.registrationCall(
                myAddress = address,
                privateKey = privateKey,
                referralCode = inputTextReferral
            )

        },
        modifier = Modifier
            .padding(30.dp)
            .clip(RoundedCornerShape(topEnd = 36.dp , bottomStart = 36.dp ,)),
        colors = ButtonDefaults.buttonColors(backgroundColor = chonolulublue)
    )
    {

        Text(text = "Submit",
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

