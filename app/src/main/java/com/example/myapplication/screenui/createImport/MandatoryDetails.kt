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
fun MandatoryDetails(
    navController: NavController,
     mnemonic: String,
    privateKey: String,
    address: String,
    referralCode: String,
){
    val context=LocalContext.current
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    var name by remember {
        mutableStateOf("")
    }

    var username by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        BasicTextField(value = name, onValueChange = {
            name = it
        })

        BasicTextField(value = username, onValueChange = {
            username = it
        })



        Button(
            onClick = {




            },
            modifier = Modifier
                .padding(30.dp)
                .clip(RoundedCornerShape(topEnd = 36.dp, bottomStart = 36.dp,)),
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