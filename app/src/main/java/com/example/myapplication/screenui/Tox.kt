package com.example.myapplication.screenui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.cgraylight
import com.example.myapplication.ui.theme.cgraystrong
import com.example.myapplication.ui.theme.cgreenlight
import com.example.myapplication.ui.theme.chonolulublue


@Composable
fun ToxScreen(){
    val localConfiguration = LocalConfiguration.current
    val cardsHeight =
        remember { (localConfiguration.screenHeightDp * 0.25f) }
    val cardsWidth = remember { (localConfiguration.screenWidthDp) }
    Tox1()
}

@Composable
fun Tox1() {

    var inputext by remember {
        mutableStateOf("What do you want to talk about?")
    }


Column(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight(0.93f)
    .padding(vertical = 8.dp, horizontal = 8.dp), verticalArrangement = Arrangement.SpaceBetween) {


    Box(modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, cgraylight)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically)
        {


            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.cinlogolarge),
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Text(text ="CryptoxIN", style = TextStyle(color = chonolulublue, fontSize = 20.sp))
                Text(text = "@prvks", style = TextStyle(color = cgraystrong, fontSize = 14.sp))
            }
        }
    }

    //middle
    //Create own text editor in kotlin
    Box(modifier = Modifier.weight(1f)) {
        BasicTextField(value = inputext, onValueChange = {
            inputext = it
        })
    }


    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {


        Column() {
            Text("# Add Hashtag",style = TextStyle(color = cgreenlight, fontSize = 20.sp))
            Row() {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_add_photo_alternate_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp),
                    tint = chonolulublue
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_videocam_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp),
                    tint = chonolulublue
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_bar_chart_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp),
                    tint = chonolulublue
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_text_fields_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp),
                    tint = chonolulublue
                )


            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_send_24),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(start = 8.dp),
            tint = chonolulublue
        )

    }




}



}



