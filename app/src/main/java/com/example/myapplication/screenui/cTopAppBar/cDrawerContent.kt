package com.example.myapplication.screenui.cTopAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.cgrayblue
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.credlight

@Composable
 fun DrawerContent(
    gradientColors: List<Color> = listOf(chonolulublue, cgrayblue) ,
    itemClick: (String) -> Unit
) {

    val itemList = prepareNavigationDrawerItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = gradientColors)),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {

        item {


            Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp),) {


            Image(
                painter = painterResource(R.drawable.dummyprofilephoto),
                contentDescription = null,
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape),
                contentScale= ContentScale.Crop
            )

            // user's name
            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = "@praveen",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            // user's email
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 30.dp),
                text = "0xf2e....7b11",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White
            )
        }
        }


        items(itemList) { item ->
            NavigationListItem(item = item) {
                itemClick(item.label)
            }
        }
    }
}