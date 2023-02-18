package com.example.myapplication.screenui.createImport

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.myapplication.R
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.cblack
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.uistate.RegisterState
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
    var referralcode by remember {
        mutableStateOf("")
    }


    if (state.value is RegisterState.Loaded){
        LaunchedEffect(key1 ="key1"){
            Log.e("1111",state.value.toString())
            navController.navigate(Screens.MandatoryDetails.route+"/${mnemonic}/${privateKey}/${address}/${referralcode}")
        }

    }




    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        Box(modifier = Modifier.height(400.dp).fillMaxWidth()){
            LoaderReferral()
        }

          Box() {

              OutlinedTextField(
                  modifier =Modifier.padding(horizontal = 24.dp),
                  label = {
                      Text(
                          text = "Enter Referral Address",
                          style = TextStyle(
                              color = cblack,
                          )
                      )
                  },
                  colors = TextFieldDefaults.outlinedTextFieldColors(
                      focusedBorderColor = chonolulublue,
                      unfocusedBorderColor = chonolulublue,
                      focusedLabelColor = cblack,
                      cursorColor =chonolulublue,
                      textColor = cblack
                  ),
                  value = referralcode,
                  onValueChange = { referralcode = it },
              )


}



    Button(
        onClick = {
            registerViewModel.registrationCall(
                myAddress = address,
                privateKey = privateKey,
                referralCode = referralcode
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

@Composable
private fun LoaderReferral() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.referral))
    val progress by animateLottieCompositionAsState(composition,
        isPlaying = true,
        reverseOnRepeat=true,
        iterations = LottieConstants.IterateForever,)
    LottieAnimation(
        composition = composition,
        progress = { progress },
    )

}
