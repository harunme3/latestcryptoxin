package com.example.myapplication.screenui.walletui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.uistate.CommentRewardS
import com.example.myapplication.ui.theme.cgraystronglight
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.viewmodels.CommentRewardVM


@Composable
fun TransactionHistoryScreen(commentRewardVM: CommentRewardVM = hiltViewModel()) {

    val commentRewardState = commentRewardVM._getCommentRewardStateFlow.collectAsState()
    Log.e("1111" , commentRewardState.value.toString())


    when (commentRewardState.value) {
        is CommentRewardS.Empty -> {
            Column(
                modifier = Modifier.fillMaxSize() ,
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(32.dp)) ,
                    color = cyellow

                )
            }
        }
        is CommentRewardS.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize() ,
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(64.dp)) ,
                    color = chonolulublue
                )
            }
        }
        is CommentRewardS.Error -> Text(text = "error")
        is CommentRewardS.Loaded -> {
            val data = (commentRewardState.value as CommentRewardS.Loaded).data.data


            Column(
                modifier = Modifier.fillMaxWidth() ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               (1..2).forEachIndexed() { index , it ->
                    Column() {
                        TransactionHistoryCard(it)
                    }
                }
            }


        }


    }


}


@Composable
fun TransactionHistoryCard(any: Any) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {
                //cin scan url
            }) ,
        elevation = 0.dp ,
        backgroundColor = cgraystronglight
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape) ,
                painter = painterResource(id = com.example.myapplication.R.drawable.cdarklogo) ,
                alignment = Alignment.CenterStart ,
                contentDescription = "" ,
                contentScale = ContentScale.Crop
            )

            Column(
                Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "2" ,
                    color = MaterialTheme.colors.surface ,
                    fontWeight = FontWeight.Bold ,
                    style = typography.subtitle1
                )
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "walletEntity.address" ,
                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
                    color = cwhite ,
                    style = typography.caption
                )
            }




            Icon(
                painter = painterResource(id = com.example.myapplication.R.drawable.ic_baseline_more_vert_24) ,
                contentDescription = null ,
                modifier = Modifier.size(24.dp) ,
                tint = Color.Red
            )
        }
    }
}
