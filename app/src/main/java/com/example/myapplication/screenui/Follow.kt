package com.example.myapplication.screenui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.data.models.alluserm.Data
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.credstronglight
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.AllUserS
import com.example.myapplication.uistate.FollowS
import com.example.myapplication.uistate.ImportWalletState
import com.example.myapplication.viewmodels.AllUserVM
import com.example.myapplication.viewmodels.FollowVM


@Composable
fun FollowScreen(allUserVM: AllUserVM = hiltViewModel() , followVM: FollowVM = hiltViewModel()) {

    val allUserState = allUserVM._getAllUserStateFlow.collectAsState()
    val followstate = followVM._getFollowStateFlow.collectAsState()

       val context=LocalContext.current;
    Log.e("1112", followstate.value.toString())

    if(followstate.value is FollowS.Loaded)
    {

        LaunchedEffect(key1 = "key1" ){
            Toast.makeText(context, "Followed", Toast.LENGTH_LONG).show()
        }



    }

    when (allUserState.value) {
        is AllUserS.Empty -> {
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
        is AllUserS.Loading -> {
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
        is AllUserS.Error -> Text(text = "error")
        is AllUserS.Loaded -> {
            val data = (allUserState.value as AllUserS.Loaded).data.data
            LazyColumn() {
                item {

                    data.forEachIndexed { index , it ->
                       FollowCard(data = it , modifier = Modifier.clickable {
                           Log.e("1111","click ${it.useraddress}")
                           followVM.getFollow(friendAddress = it.useraddress)
                       })
                    }

                }
            }


        }


    }


}


//----------------New card------------------------//


@Composable
fun FollowCard(data: Data ,modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
          ,
        elevation = 0.dp ,
        backgroundColor = cyellow
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            val image: Painter = painterResource(id = R.drawable.dummyprofilephoto)
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape) ,
                painter = image ,
                alignment = Alignment.CenterStart ,
                contentDescription = "" ,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = data.Name ,
                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
                    color = MaterialTheme.colors.surface ,
                    fontWeight = FontWeight.Bold ,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = data.UserName ,
                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
                    color = cwhite ,
                    style = MaterialTheme.typography.caption
                )

                Row(verticalAlignment = Alignment.Bottom) {

                    val location: Painter = painterResource(id = R.drawable.home)

                    Icon(
                        painter = location ,
                        contentDescription = null ,
                        modifier = Modifier.size(16.dp , 16.dp) ,
                        tint = Color.Red
                    )

                    Text(
                        text = data.designation ,
                        modifier = Modifier.padding(8.dp , 12.dp , 12.dp , 0.dp) ,
                        color = MaterialTheme.colors.surface ,
                        style = MaterialTheme.typography.caption

                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxSize() ,
                horizontalArrangement = Arrangement.End ,
                verticalAlignment = Alignment.CenterVertically

            ) {
                ChipView(text = "Follow" , colorResource = chonolulublue)
            }
        }
    }
}


@Composable
fun ChipView(text: String , colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                colorResource.copy(.08f)
            )
    ) {
        Text(
            text = text , modifier = Modifier.padding(12.dp , 6.dp , 12.dp , 6.dp) ,
            style = MaterialTheme.typography.caption ,
            color = colorResource
        )
    }
}

