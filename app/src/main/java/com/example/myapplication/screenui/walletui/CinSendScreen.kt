package com.example.myapplication.screenui.walletui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.uistate.CinSendS
import com.example.myapplication.viewmodels.CinSendVM


@Composable
fun CinSendScreen(navController: NavController,cinSendVM: CinSendVM= hiltViewModel()){
    val cinSendState = cinSendVM._getCinSendStateFlow.collectAsState()
    var address by remember { mutableStateOf(TextFieldValue("")) }
    var amount by remember { mutableStateOf(TextFieldValue("")) }


    Log.e("1111",cinSendState.value.toString())

    if (cinSendState.value is CinSendS.Loaded){
        LaunchedEffect(key1 ="key1"){
            navController.popBackStack()
        }

    }

    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {



        OutlinedTextField(
            modifier =Modifier.padding(horizontal = 24.dp),
            label = {
                Text(
                    text = "Enter Receiver Address",
                    style = TextStyle(
                        color = MaterialTheme.colors.primaryVariant,
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.secondary,
                unfocusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.secondary,
                cursorColor = MaterialTheme.colors.primaryVariant
            ),
            value = address,
            onValueChange = { address = it },
        )

        OutlinedTextField(
            label = {
                Text(
                    text = "Enter Amount",
                    style = TextStyle(
                        color = MaterialTheme.colors.primaryVariant,
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.secondary,
                unfocusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.secondary,
                cursorColor = MaterialTheme.colors.primaryVariant
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            value = amount,
            onValueChange = { amount = it },
        )
Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(

            onClick = {
                cinSendVM.getCinSend(receiver = address.text.toString(),amount=amount.text.toString())
            }
        ) {
            Text(text="Send",    modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp),)
        }




    }
    }