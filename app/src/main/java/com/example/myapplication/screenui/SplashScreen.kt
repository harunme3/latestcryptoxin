package com.example.myapplication.screenui


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.navigation.Graph
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.RainbowColors
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.viewmodels.CreateWalletViewModels
import kotlinx.coroutines.delay

@OptIn(ExperimentalTextApi::class)
@Composable
fun SplashScreen(navController: NavHostController,createWalletViewModels: CreateWalletViewModels = hiltViewModel()) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    LaunchedEffect(key1 = Unit) {

        delay(10)
          Log.e("1111", createWalletViewModels.getWallet(walletId = 1).toString())
       //Write condition have account or not

        if (true) {
            navController.popBackStack()
            navController.navigate(Screens.CreateImport.route)
        } else {
            navController.popBackStack()
            navController.navigate(Graph.DASHBOARD)
        }
    }



    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(com.example.myapplication.R.drawable.cbackground),
            contentDescription =  "CBackground",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = com.example.myapplication.R.drawable.clightlogo),
                contentDescription = "CLogo",
            )
       Box(modifier =Modifier.height(40.dp))
            Text(text = "Welcome to Web 3.0 based\n Social Media Platform",
            style = TextStyle(
                color = cwhite,
               fontSize = 14.sp
            ),
              textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = "Proudly made in India!",
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = RainbowColors,
                        tileMode = TileMode.Mirror
                    ),
                    fontSize = 25.sp
                )
            )
        }


    }


}


