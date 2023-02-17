package com.example.myapplication.screenui.cTopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R

@Composable
 fun prepareNavigationDrawerItems(): List<NavigationDrawerItem> {
    val itemsList = arrayListOf<NavigationDrawerItem>()

    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.home),
            label = "Referral"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.comment),
            label = "Rewards",
            showUnreadBubble = true
        )
    )



    return itemsList
}

data class NavigationDrawerItem(
    val image: Painter ,
    val label: String ,
    val showUnreadBubble: Boolean = false
)