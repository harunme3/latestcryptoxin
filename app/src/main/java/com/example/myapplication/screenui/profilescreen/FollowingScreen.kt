package com.example.myapplication.screenui.profilescreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.data.models.followingm.Data
import com.example.myapplication.ui.theme.cgraystronglight
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.FollowingS
import com.example.myapplication.viewmodels.FollowingVM


@Composable
fun FollowingScreen(navController: NavController ,followingVM: FollowingVM = hiltViewModel() ,){


    val followingState = followingVM._getFollowingStateFlow.collectAsState()
    Log.e("1111",followingState.value.toString())
    when (followingState.value) {
        is FollowingS.Empty -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(32.dp)),
                    color = cyellow

                )
            }
        }
        is FollowingS.Loading -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(64.dp)),
                    color = chonolulublue
                )
            }
        }
        is FollowingS.Error -> Text(text = "error")
        is FollowingS.Loaded -> {
            val context= LocalContext.current
            val clipboardManager: ClipboardManager = LocalClipboardManager.current
            val data=(followingState.value as FollowingS.Loaded).data.data
            Toast.makeText(context, "${data}", Toast.LENGTH_SHORT).show()

            Box(
            ) {
                LazyColumn(){
                    item {
                        data.forEachIndexed { index, it ->
                            WalletCard2(it)
                        }
                    }
                }

            }


        }


    }

}




@Composable
fun WalletCard2(data: Data) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)) ,
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
                painter = painterResource(id = R.drawable.cdarklogo) ,
                alignment = Alignment.CenterStart ,
                contentDescription = "" ,
                contentScale = ContentScale.Crop
            )

            Column(
                Modifier
                    .weight(1f)
            ) {
                Text(
                    text = data.UserName,
                    color = MaterialTheme.colors.surface ,
                    fontWeight = FontWeight.Bold ,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text =data.Name ,
                    modifier = Modifier.padding(0.dp , 0.dp , 12.dp , 0.dp) ,
                    color = cwhite ,
                    style = MaterialTheme.typography.caption
                )
            }




            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_more_vert_24) ,
                contentDescription = null ,
                modifier = Modifier.size(24.dp) ,
                tint = Color.Red
            )
        }
    }
}

