package com.example.myapplication.screenui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.navigation.Graph
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.RainbowColors
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.uistate.WalletS
import com.example.myapplication.viewmodels.WalletVM
import kotlinx.coroutines.delay

@OptIn(ExperimentalTextApi::class)
@Composable
fun SplashScreen(navController: NavHostController,walletVM: WalletVM = hiltViewModel()) {
    val state = walletVM._getAllWalletStateFlow.collectAsState()

    if (state.value is WalletS.Loaded){
        LaunchedEffect(key1 = true) {

            delay(10)

            if ((state.value as WalletS.Loaded).data.isEmpty()) {
                navController.popBackStack()
                navController.navigate(Screens.CreateImport.route)
            } else {
                navController.popBackStack()
              navController.navigate(Graph.DASHBOARD)

            }
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


