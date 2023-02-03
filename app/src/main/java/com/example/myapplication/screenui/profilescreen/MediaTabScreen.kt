package com.example.myapplication.screenui.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.cgraystrong
import com.example.myapplication.ui.theme.cyellow

@Composable
fun MediaTabScreen(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        (1..10).forEachIndexed() { index,it->
            Column() {
                Box(modifier = Modifier.padding(2.dp).background(color = cyellow)) {
                    Text(
                        text = "${index + 1} Media",
                        color = cgraystrong,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }

            }
        }
    }
}