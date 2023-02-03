package com.example.myapplication.screenui.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.cgraystrong
import com.example.myapplication.ui.theme.cgreenmostlight
import com.example.myapplication.ui.theme.cyellow


@Composable
fun TweetsTabScreen(){
    
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        (1..100).forEachIndexed() { index,it->
           Column() {
                Box(modifier = Modifier.padding(2.dp).background(color = cyellow)) {
                    Text(
                        text = "${index + 1} Tweet",
                        color = cgraystrong,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }

            }
        }
    }

}