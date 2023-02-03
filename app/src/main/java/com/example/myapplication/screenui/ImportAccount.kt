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
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.navigation.Graph
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.cblack
import com.example.myapplication.ui.theme.cgraylight
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.uistate.GetUserState
import com.example.myapplication.uistate.ImportWalletState
import com.example.myapplication.viewmodels.CreateWalletViewModels
import com.example.myapplication.viewmodels.GetUserViewModel
import com.example.myapplication.viewmodels.ImportWalletViewModel

@Composable
fun ImportAccount(navController: NavController,
                  importAccountModel: ImportWalletViewModel = hiltViewModel(),
                  getUserViewModel: GetUserViewModel= hiltViewModel(),
                  createWalletViewModels: CreateWalletViewModels = hiltViewModel()
                 ){
    val state = importAccountModel._importWalletStateFlow.collectAsState()
    val stateGetUser = getUserViewModel._getUserStateFlow.collectAsState()
    val context=LocalContext.current
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    var inputText by remember {
        mutableStateOf("")
    }

    if(state.value is ImportWalletState.Loaded)
    {
        val data=(state.value as ImportWalletState.Loaded).data
        Log.v("1111", data.toString())
        getUserViewModel
            .getUserCall(
                myAddress = data.address,
               )

        if(stateGetUser.value is GetUserState.Loaded)
        {
            val getUserData=(stateGetUser.value as GetUserState.Loaded).data
            Log.d("1111", getUserData.toString())
            LaunchedEffect(key1 = Unit) {

                Log.v("1111", getUserData.toString())
                if(getUserData.data)
                {
                 navController.navigate(Screens.DashBoard.route)

                    if (inputText.length==66)
                    {

                        val customMnemonic="customMnemonic"
                        createWalletViewModels.createWallet(WalletEntity(null,mnemonicPhrase=customMnemonic,privateKey=data.privateKey,address=data.address))
//                        navController.navigate(Graph.DASHBOARD)
                    }
                    else
                    {
                        createWalletViewModels.createWallet(WalletEntity(null,mnemonicPhrase=inputText,privateKey=data.privateKey,address=data.address))

//                        navController.navigate(Graph.DASHBOARD)
                    }


                }
                else
                {
                    if (inputText.length==66)
                    {

                        val customMnemonic="customMnemonic"
                        navController.navigate(Screens.ReferralScreen.route+"/$customMnemonic/${data.privateKey}/${data.address}")
                    }
                    else
                    {
                        navController.navigate(Screens.ReferralScreen.route+"/$inputText/${data.privateKey}/${data.address}")
                    }
                }



            }

        }




    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(modifier = Modifier.fillMaxWidth()) {
            Row() {
              Box(modifier=
              Modifier
                  .border(1.dp, cblack)
                  .fillMaxWidth(0.5f),
                  contentAlignment=Alignment.Center
              ){
                 Text(text = "Private", style = TextStyle(fontSize = 24.sp,),
                 maxLines = 1,
                     textAlign = TextAlign.Center
                     )
              }

                Box(modifier= Modifier
                    .border(1.dp, cblack)
                    .fillMaxWidth(), contentAlignment=Alignment.Center) {
                Text(text = "mnemonic", style = TextStyle(fontSize = 24.sp,), maxLines = 1,)
                }
            }

                 Box(modifier = Modifier
                     .height(200.dp)
                     .fillMaxWidth()
                     .border(1.dp, cblack)) {

                 Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {
                     BasicTextField(value = inputText, onValueChange = {
                         inputText = it
                     })
                     Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                         Box(modifier = Modifier
                             .padding(2.dp)
                             .clickable {
                                 clipboardManager.getText()?.text?.let {
                                     inputText = it
                                 }

                             }) {
                             Text(
                                 text = "Paste",
                                 modifier = Modifier
                                     .background(
                                         color = cgraylight,
                                         shape = RoundedCornerShape(16.dp)
                                     )
                                     .padding(8.dp),
                                 overflow = TextOverflow.Ellipsis,
                                 maxLines = 1
                             )
                         }
                     }
                 }


                }


        }


        Button(
            onClick = {
                //check
Log.e("1111",inputText)
                if (inputText.length==64)
                {
                    Log.v("1111",inputText)
                    importAccountModel
                        .importWalletCall(
                            privateKey = inputText,
                            mnemonic = "")

                }
                else
                {
                    Log.d("1111",inputText)
                    importAccountModel
                        .importWalletCall(
                            privateKey = "",
                            mnemonic = inputText)
                }



            },
            modifier = Modifier
                .padding(30.dp)
                .clip(RoundedCornerShape(topEnd = 36.dp, bottomStart = 36.dp,)),
            colors = ButtonDefaults.buttonColors(backgroundColor = chonolulublue)
        )
        {


                Text(text = "Import",
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