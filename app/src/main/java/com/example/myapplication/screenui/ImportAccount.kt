package com.example.myapplication.screenui

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
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.myapplication.R
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.data.models.importaccountmodel.ImportAccountModel
import com.example.myapplication.navigation.Graph
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.cgraystrong
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.GetUserState
import com.example.myapplication.uistate.ImportWalletState
import com.example.myapplication.viewmodels.GetUserViewModel
import com.example.myapplication.viewmodels.ImportWalletViewModel
import com.example.myapplication.viewmodels.WalletVM


@Composable
fun ImportAccount(
    navController: NavController ,
    importAccountModel: ImportWalletViewModel = hiltViewModel() ,
    getUserViewModel: GetUserViewModel = hiltViewModel() ,
    walletVM: WalletVM = hiltViewModel()
){
    Column(
      modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Done1Loader()
        }

        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Done2Loader()
        }

        Text(text = "Now You are Pre-Registered to CryptoxIN", style = TextStyle(fontSize = 18.sp))
        Text(text = "Keep Referring", style = TextStyle(fontSize = 24.sp))

    }

}

@Composable
private fun Done1Loader() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.congratulations))
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

@Composable
private fun Done2Loader() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.done))
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







@Composable
fun ImportAccount1(
    navController: NavController ,
    importAccountModel: ImportWalletViewModel = hiltViewModel() ,
    getUserViewModel: GetUserViewModel = hiltViewModel() ,
    walletVM: WalletVM = hiltViewModel()
) {
    val state = importAccountModel._importWalletStateFlow.collectAsState()
    val stateGetUser = getUserViewModel._getUserStateFlow.collectAsState()
    val context = LocalContext.current
    val clipboardManager: ClipboardManager = LocalClipboardManager.current


    var inputText by remember {
        mutableStateOf("")
    }
    var data: ImportAccountModel by remember {
        mutableStateOf(ImportAccountModel(false , "" , ""))
    }


    if (state.value is ImportWalletState.Loaded) {

        LaunchedEffect(key1 = "key1") {
            data = (state.value as ImportWalletState.Loaded).data
            Log.v("1112" , (state.value as ImportWalletState.Loaded).data.toString())
            Log.e("1112" , data.toString())
            getUserViewModel
                .getUserCall(
                    myAddress = data.address ,
                )
        }


    }
    Log.d("1111" , stateGetUser.value.toString())
    if (stateGetUser.value is GetUserState.Loaded) {

        LaunchedEffect(key1 = "key2") {
            val getUserData = (stateGetUser.value as GetUserState.Loaded).data
            Log.e("1111" , getUserData.toString())

            if (getUserData.data) {

                if (inputText.length >= 64 && inputText.length <= 66) {
                    val customMnemonic = "customMnemonic"
                    walletVM.createWallet(
                        WalletEntity(
                            null ,
                            mnemonicPhrase = customMnemonic ,
                            privateKey = data.privateKey ,
                            address = data.address
                        )
                    )
                    navController.navigate(Graph.DASHBOARD)
                } else {
                    walletVM.createWallet(
                        WalletEntity(
                            null ,
                            mnemonicPhrase = inputText ,
                            privateKey = data.privateKey ,
                            address = data.address
                        )
                    )
                    navController.navigate(Graph.DASHBOARD)
                }


            } else {
                if (inputText.length >= 64 && inputText.length <= 66) {
                    val customMnemonic = "customMnemonic"
                    navController.navigate(Screens.ReferralScreen.route + "/$customMnemonic/${data.privateKey}/${data.address}")
                } else {
                    navController.navigate(Screens.ReferralScreen.route + "/$inputText/${data.privateKey}/${data.address}")
                }
            }
        }

    }





    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
        ) {
            LoaderImport()
        }


        Column(modifier = Modifier.fillMaxWidth()) {
//------------------------------------------------------------------

            Row() {
                Box(
                    modifier =
                    Modifier
                        .background(color = cyellow)
                        .border(1.dp , cyellow)
                        .fillMaxWidth(0.5f)
                        .height(48.dp) ,
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Private Key" , style = TextStyle(fontSize = 18.sp) ,
                        maxLines = 1 ,
                        color= cwhite,
                        textAlign = TextAlign.Center
                    )
                }

                Box(
                    Modifier
                        .background(color = chonolulublue)
                        .border(1.dp , chonolulublue)
                        .fillMaxWidth()
                        .height(48.dp) ,
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Mnemonic Phrase" ,
                        color= cwhite,
                        style = TextStyle(fontSize = 18.sp) , maxLines = 1)
                }
            }


//------------------------------------------------------------------


            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .border(1.dp , chonolulublue)
            ) {

                Column(
                    verticalArrangement = Arrangement.SpaceBetween ,
                    modifier = Modifier.fillMaxSize()
                ) {
                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp) ,
                        value = inputText ,
                        onValueChange = {
                            inputText = it
                        },
                        decorationBox = { innerTextField ->
                            if (inputText.isEmpty()) {
                                Text(
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    text="Enter Private Key OR Mnemonic Phrase",
                                    style = TextStyle(color = cgraystrong, fontSize = 18.sp),

                                    )
                            }
                            innerTextField()
                        },

                    )
                    Row(
                        horizontalArrangement = Arrangement.End ,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                clipboardManager.getText()?.text?.let {
                                    inputText = it
                                }

                            }) {
                            Text(
                                text = "Paste" ,
                                color = cwhite ,
                                modifier = Modifier
                                    .background(
                                        color = cyellow ,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .padding(vertical = 8.dp , horizontal = 12.dp) ,
                                overflow = TextOverflow.Ellipsis ,
                                maxLines = 1
                            )
                        }
                    }
                }


            }


        }


        Button(
            onClick = {
                if (inputText.length >= 64 && inputText.length <= 66) {
                    Log.e("1111" , "called")
                    importAccountModel
                        .importWalletCall(
                            privateKey = inputText ,
                            mnemonic = ""
                        )
                } else {
                    importAccountModel
                        .importWalletCall(
                            privateKey = "" ,
                            mnemonic = inputText
                        )
                }


            } ,
            modifier = Modifier
                .padding(30.dp)
                .clip(RoundedCornerShape(topEnd = 36.dp , bottomStart = 36.dp)) ,
            colors = ButtonDefaults.buttonColors(backgroundColor = chonolulublue)
        )
        {


            Text(
                text = "Import" ,
                style = TextStyle(
                    color = cwhite ,
                    fontSize = 18.sp
                ) ,
                textAlign = TextAlign.Center ,
                modifier = Modifier.padding(horizontal = 24.dp , vertical = 12.dp)
            )


        }
    }
}


@Composable
private fun LoaderImport() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.wallet))
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
