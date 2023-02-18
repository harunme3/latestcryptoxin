package com.example.myapplication.screenui.createImport

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.airbnb.lottie.compose.*
import com.example.myapplication.R
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.navigation.Graph
import com.example.myapplication.ui.theme.cblack
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.uistate.ProfileUpdateS
import com.example.myapplication.viewmodels.ProfileUpdateInitialVM
import com.example.myapplication.viewmodels.ProfileUpdateVM
import com.example.myapplication.viewmodels.WalletVM

@Composable
fun MandatoryDetails(
     navController: NavController,
     mnemonic: String,
     privateKey: String,
     address: String,
     referralCode: String,
   profileUpdateInitialVM: ProfileUpdateInitialVM= hiltViewModel(),
     walletVM: WalletVM = hiltViewModel()
){

    val state = profileUpdateInitialVM._setProfileUpdateInitialStateFlow.collectAsState()
    val context=LocalContext.current
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    Log.e("3333",state.value.toString())

    var btntextmand by remember {
        mutableStateOf("Submit")
    }

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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
        ) {
            MandatoryDetailsLoaderImport()
        }


        OutlinedTextField(
            modifier =Modifier.padding(horizontal = 24.dp),
            label = {
                Text(
                    text = "Enter Full Name",
                    style = TextStyle(
                        color = cblack ,
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = chonolulublue,
                unfocusedBorderColor = chonolulublue,
                focusedLabelColor = cblack ,
                cursorColor =chonolulublue,
                textColor = cblack
            ),
            value = name,
            onValueChange = { name = it },
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            modifier =Modifier.padding(horizontal = 24.dp),
            label = {
                Text(
                    text = "Enter User Name",
                    style = TextStyle(
                        color = cblack ,
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = chonolulublue,
                unfocusedBorderColor = chonolulublue,
                focusedLabelColor = cblack ,
                cursorColor =chonolulublue,
                textColor = cblack
            ),
            value = username,
            onValueChange = { username = it },
        )



        Button(
            onClick = {

                btntextmand="Submitting"
                profileUpdateInitialVM.setProfileUpdate(
                    myAddress =address ,
                    privateKey=privateKey,
                    name = name ,
                    UserName ="@${username}",
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

            Text(text = btntextmand,
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

@Composable
private fun MandatoryDetailsLoaderImport() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.profile))
    val progress by animateLottieCompositionAsState(
        composition ,
        isPlaying = true ,
        reverseOnRepeat = true ,
        iterations = LottieConstants.IterateForever ,
    )
    LottieAnimation(
        composition = composition ,
        progress = { progress } ,
    )

}