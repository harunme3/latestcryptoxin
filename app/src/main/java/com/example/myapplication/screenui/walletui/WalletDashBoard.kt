package com.example.myapplication.screenui.walletui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.ui.theme.cyellow

@Composable
fun WalletDashboard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(8.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp,
                    bottomStart = 24.dp,
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
                            topStart = 24.dp,
                            topEnd = 24.dp,
                            bottomStart = 24.dp,
                            bottomEnd = 24.dp
                        )
                    )
                    .background(color = cwhite)
            ) {

                Column(verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)) {

                    //upper
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Row(){
                            Text(text = "0x4......7129")
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_content_copy_24),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp).padding(start = 8.dp),
                            )
                        }

                        Row(){

                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_lock_open_24),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = chonolulublue
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_screen_share_24),
                                contentDescription = null,
                                modifier = Modifier.size(28.dp).padding(start = 8.dp),
                                tint = chonolulublue
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_computer_24),
                                contentDescription = null,
                                modifier = Modifier.size(28.dp).padding(start = 8.dp),
                                tint = chonolulublue
                            )
                        }
                    }

                    //middle

                    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {

                        Image(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.cinlogosmall),
                            alignment = Alignment.CenterStart,
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                    }

                    Row( modifier = Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
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


                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(modifier = Modifier
                        .padding(4.dp)
                        .size(48.dp)
                        .aspectRatio(1f)
                        .background(cwhite, shape = CircleShape)
                        .border(2.dp, cyellow, CircleShape) ,//add a boarder color if requires,
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cinbsend),
                            contentDescription = "image",
                            contentScale = ContentScale.Crop,
                            modifier=  Modifier
                                .size(24.dp)
//
                        )

                    }

                    Box(modifier = Modifier
                        .padding(4.dp)
                        .size(48.dp)
                        .aspectRatio(1f)
                        .background(cwhite, shape = CircleShape)
                        .border(2.dp, cyellow, CircleShape) ,//add a boarder color if requires,
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cinbreceive),
                            contentDescription = "image",
                            contentScale = ContentScale.Crop,
                            modifier=  Modifier
                                .size(24.dp)
                        )

                    }

                }
            }


        }

    }


}
