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
            label = "Home"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.comment),
            label = "Messages",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.home),
            label = "Notifications",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.wallet),
            label = "Profile"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.tox),
            label = "Payments"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.profile),
            label = "Settings"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.follow),
            label = "Logout"
        )
    )

    return itemsList
}

data class NavigationDrawerItem(
    val image: Painter ,
    val label: String ,
    val showUnreadBubble: Boolean = false
)