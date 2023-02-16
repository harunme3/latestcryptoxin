package com.example.myapplication.screenui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.WalletIdS
import com.example.myapplication.viewmodels.WalletVM


@Composable
fun WalletScreen(navController: NavController, walletVM: WalletVM = hiltViewModel() ,) {
    LaunchedEffect(Unit){
        walletVM.getWallet(walletId = 1)
    }
    val state = walletVM._getWalletStateFlow.collectAsState()
    when (state.value) {
        is WalletIdS.Empty -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(32.dp)),
                    color = cyellow

                )
            }
        }
        is WalletIdS.Loading -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(64.dp)),
                    color = chonolulublue
                )
            }
        }
        is WalletIdS.Error -> Text(text = "error")
        is WalletIdS.Loaded -> {
            val context= LocalContext.current
            val clipboardManager: ClipboardManager = LocalClipboardManager.current
            val data=(state.value as WalletIdS.Loaded).data
            WalletComponent(data)

        }


    }

}


@Composable
fun WalletComponent(data: WalletEntity) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(8.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 24.dp ,
                    topEnd = 24.dp ,
                    bottomStart = 24.dp ,
                    bottomEnd = 24.dp
                )
            )
            .background(color = chonolulublue)
    ) {


        Column() {

            //upper
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .height(160.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 24.dp ,
                            topEnd = 24.dp ,
                            bottomStart = 24.dp ,
                            bottomEnd = 24.dp
                        )
                    )
                    .background(color = cwhite)
            ) {

                Column(
                    verticalArrangement = Arrangement.SpaceBetween ,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {

                    //upper
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween ,
                        modifier = Modifier.fillMaxWidth() ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row() {
                            Text(text = data.address.substring(0,10))
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_content_copy_24) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(start = 8.dp) ,
                            )
                        }

                        Row() {

                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_lock_open_24) ,
                                contentDescription = null ,
                                modifier = Modifier.size(24.dp) ,
                                tint = chonolulublue
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_screen_share_24) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(28.dp)
                                    .padding(start = 8.dp) ,
                                tint = chonolulublue
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_computer_24) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(28.dp)
                                    .padding(start = 8.dp) ,
                                tint = chonolulublue
                            )
                        }
                    }

                    //middle

                    Row(
                        horizontalArrangement = Arrangement.Center ,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Image(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape) ,
                            painter = painterResource(id = R.drawable.cinlogosmall) ,
                            alignment = Alignment.CenterStart ,
                            contentDescription = "" ,
                            contentScale = ContentScale.Crop
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth() ,
                        horizontalArrangement = Arrangement.SpaceBetween ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column() {
                            Text(text = "Available balance")
                            Text(text = "1000 COIN")
                        }
                        Column() {
                            Text(text = "Net Worth")
                            Text(text = "$50")
                        }
                        Column() {
                            Text(text = "Cin Price")
                            Text(text = "@0.001")
                        }
                    }

                }
            }


            //down

            Box(
                modifier = Modifier
                    .fillMaxWidth()

            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp) ,
                    horizontalArrangement = Arrangement.SpaceEvenly ,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(48.dp)
                            .aspectRatio(1f)
                            .background(cwhite , shape = CircleShape)
                            .border(
                                2.dp ,
                                cyellow ,
                                CircleShape
                            ) ,//add a boarder color if requires,
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cinbsend) ,
                            contentDescription = "image" ,
                            contentScale = ContentScale.Crop ,
                            modifier = Modifier
                                .size(24.dp)
//
                        )

                    }

                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(48.dp)
                            .aspectRatio(1f)
                            .background(cwhite , shape = CircleShape)
                            .border(
                                2.dp ,
                                cyellow ,
                                CircleShape
                            ) ,//add a boarder color if requires,
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cinbreceive) ,
                            contentDescription = "image" ,
                            contentScale = ContentScale.Crop ,
                            modifier = Modifier
                                .size(24.dp)
                        )

                    }

                }
            }


        }

    }
}


//
//@Composable
//fun WalletCardUselater( walletEntity: WalletEntity , navController: NavController , walletVM: WalletVM) {
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .padding(8.dp)
//            .clip(RoundedCornerShape(16.dp))
//            .clickable(onClick = {
//                navController.navigate(Screens.WalletDashboardScreen.route + "/${walletEntity.walletId}")
//            }),
//        elevation = 0.dp,
//        backgroundColor = cgraystronglight
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Image(
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(CircleShape),
//                painter = painterResource(id =com.example.myapplication.R.drawable.cdarklogo),
//                alignment = Alignment.CenterStart,
//                contentDescription = "",
//                contentScale = ContentScale.Crop
//            )
//
//            Column( Modifier
//                .weight(1f)) {
//                Text(
//                    text =walletEntity.walletId.toString(),
//                    color = MaterialTheme.colors.surface,
//                    fontWeight = FontWeight.Bold,
//                    style = typography.subtitle1
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//
//                Text(
//                    text =walletEntity.address,
//                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
//                    color = cwhite,
//                    style = typography.caption
//                )
//            }
//
//
//
//
//            Icon(
//                painter = painterResource(id = com.example.myapplication.R.drawable.ic_baseline_more_vert_24),
//                contentDescription = null,
//                modifier = Modifier.size(24.dp),
//                tint = Color.Red
//            )
//        }
//    }
//}
