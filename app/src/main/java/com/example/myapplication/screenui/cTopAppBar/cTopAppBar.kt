package com.example.myapplication.screenui.cTopAppBar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite

@Composable
 fun CTopAppBar( title:String ,modifier: Modifier, onNavIconClick: () -> Unit) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = chonolulublue,
        contentColor = cwhite,
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavIconClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Open Navigation Drawer"
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                 println("notification")
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notification"
                )
            }
        }
    )
}