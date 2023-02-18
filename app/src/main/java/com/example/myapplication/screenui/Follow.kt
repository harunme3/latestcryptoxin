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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.data.models.alluserm.Data
import com.example.myapplication.ui.theme.*
import com.example.myapplication.uistate.AllUserS
import com.example.myapplication.uistate.FollowS
import com.example.myapplication.uistate.ImportWalletState
import com.example.myapplication.viewmodels.AllUserVM
import com.example.myapplication.viewmodels.FollowVM


@Composable
fun FollowScreen(allUserVM: AllUserVM = hiltViewModel() ,followVM: FollowVM = hiltViewModel()) {


    DoneScreen()
//    val allUserState = allUserVM._getAllUserStateFlow.collectAsState()
//    val followstate = followVM._getFollowStateFlow.collectAsState()
//
//       val context=LocalContext.current
//    Log.e("1112", followstate.value.toString())
//
//    if(followstate.value is FollowS.Loaded)
//    {
//
//        LaunchedEffect(key1 = "key1" ){
//            Toast.makeText(context, "Followed", Toast.LENGTH_LONG).show()
//        }
//
//
//
//    }
//
//    when (allUserState.value) {
//        is AllUserS.Empty -> {
//            Column(
//                modifier = Modifier.fillMaxSize() ,
//                verticalArrangement = Arrangement.Center ,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                CircularProgressIndicator(
//                    modifier = Modifier.then(Modifier.size(32.dp)) ,
//                    color = cyellow
//
//                )
//            }
//        }
//        is AllUserS.Loading -> {
//            Column(
//                modifier = Modifier.fillMaxSize() ,
//                verticalArrangement = Arrangement.Center ,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                CircularProgressIndicator(
//                    modifier = Modifier.then(Modifier.size(64.dp)) ,
//                    color = chonolulublue
//                )
//            }
//        }
//        is AllUserS.Error -> Text(text = "error")
//        is AllUserS.Loaded -> {
//            val data = (allUserState.value as AllUserS.Loaded).data.data
//            LazyColumn() {
//                item {
//
//                    data.forEachIndexed { index , it ->
//                       FollowCard(data = it , modifier = Modifier.clickable {
//                           Log.e("1111","click ${it.useraddress}")
//                           followVM.getFollow(friendAddress = it.useraddress)
//                       })
//                    }
//
//                }
//            }
//
//
//        }
//
//
//    }


}


//----------------New card------------------------//


//@Composable
//fun FollowCard(data: Data ,modifier: Modifier) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clip(RoundedCornerShape(16.dp)) ,
//        elevation = 0.dp ,
//        backgroundColor = cgraystrongest
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Image(
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(CircleShape) ,
//                painter = painterResource(id = R.drawable.dummyprofilephoto),
//                alignment = Alignment.CenterStart ,
//                contentDescription = "" ,
//                contentScale = ContentScale.Crop
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
//                Text(
//                    text = data.Name ,
//                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
//                    color = cwhite,
//                    fontWeight = FontWeight.Bold ,
//                    style = MaterialTheme.typography.subtitle1,
//
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//
//                Text(
//                    text ="@${data.UserName}",
//                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
//                    color = cwhite ,
//                    style = MaterialTheme.typography.caption
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//
//                Text(
//                    text ="${data.designation}",
//                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
//                    color = cwhite ,
//                    style = MaterialTheme.typography.caption
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//
//                Text(
//                    text ="${data.Organization}",
//                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
//                    color = cwhite ,
//                    style = MaterialTheme.typography.caption
//                )
//
//
//            }
//            Row(
//                modifier = Modifier.fillMaxSize() ,
//                horizontalArrangement = Arrangement.End ,
//                verticalAlignment = Alignment.CenterVertically
//
//            ) {
//                ChipView(text = "Follow" , colorResource = chonolulublue, modifier = modifier)
//            }
//        }
//    }
//}
//
//
//@Composable
//fun ChipView(text: String , colorResource: Color,modifier: Modifier) {
//    Box(
//        modifier = modifier
//            .wrapContentWidth()
//            .clip(RoundedCornerShape(12.dp))
//            .background(
//               color = cwhite
//            )
//    ) {
//        Text(
//            text = text , modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp) ,
//            style = TextStyle(fontWeight = FontWeight.Bold) ,
//            color = colorResource
//        )
//    }
//}

