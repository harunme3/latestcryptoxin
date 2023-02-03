package com.example.myapplication.screenui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.cgraystronglight
import com.example.myapplication.ui.theme.cwhite

@Composable
fun WalletScreen(){
    LazyColumn(){
        item {
            (1..50).forEach {
               WalletCard1()
            }
        }
    }
}




@Composable
fun WalletCard1() {
    Card(
        modifier = Modifier
            .fillMaxWidth().
              height(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {
                //Navigate to profile
            }),
        elevation = 0.dp,
        backgroundColor = cgraystronglight
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal =  8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    painter = painterResource(id =com.example.myapplication.R.drawable.dummyprofilephoto),
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Column( Modifier

                    .weight(1f)) {
                    Text(
                        text = "Praveen",

                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,
                        style = typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = buildString {
                            append("@prvks")
                            append("yrs | ")
                            append("male")
                        },
                        modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                        color = cwhite,
                        style = typography.caption
                    )

                    Row(verticalAlignment = Alignment.Bottom) {

                        val location: Painter =
                            painterResource(id = com.example.myapplication.R.drawable.home)

                        Icon(
                            painter = location,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp, 16.dp),
                            tint = Color.Red
                        )

                        Text(
                            text = "Entrepreneur",
                            modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                            color = MaterialTheme.colors.surface,
                            style = typography.caption

                        )
                    }
                }




            Icon(
                painter = painterResource(id = com.example.myapplication.R.drawable.ic_baseline_more_vert_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Red
            )
        }
    }
}

