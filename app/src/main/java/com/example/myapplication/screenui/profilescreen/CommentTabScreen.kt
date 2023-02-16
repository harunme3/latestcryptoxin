package com.example.myapplication.screenui.profilescreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.data.models.userpostm.Data
import com.example.myapplication.ui.theme.cblack
import com.example.myapplication.ui.theme.cgraystrongest
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.UserPostS
import com.example.myapplication.viewmodels.DeletePostVM
import com.example.myapplication.viewmodels.LikePostVM
import com.example.myapplication.viewmodels.UserPostVM
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText


@Composable
fun CommentTabScreen(userPostVM: UserPostVM = hiltViewModel() , deletePostVM: DeletePostVM = hiltViewModel() , likePostVM: LikePostVM = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val userPostState = userPostVM._getUserPostStateFlow.collectAsState()
    val deletePostState = deletePostVM._getDeletePostStateFlow.collectAsState()
    val likePostState = likePostVM._getLikePostStateFlow.collectAsState()
    Log.e("1111",likePostState.value.toString())


    when (userPostState.value) {
        is UserPostS.Empty -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(32.dp)),
                    color = cyellow

                )
            }
        }
        is UserPostS.Loading -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(64.dp)),
                    color = chonolulublue
                )
            }
        }
        is UserPostS.Error -> Text(text = "error")
        is UserPostS.Loaded -> {
            val data=(userPostState.value as UserPostS.Loaded).data.data


            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                data.forEachIndexed() { index,it->
                    Column() {
                        CommentTabCard(
                            it,
                            deletePostVM,
                            likePostVM,
                            )

                    }
                }
            }


        }


    }


}



@Composable
fun CommentTabCard(
    data: Data ,
    deletePostVM: DeletePostVM ,
    likePostVM: LikePostVM
) {

    val contextForToast = LocalContext.current.applicationContext
    val listItems = listOf<String>("Edit", "Delete","Report")
    val disabledItem = 2
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 0.dp,
    ) {
        Column() {
            Divider(modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth())
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {

                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    painter = rememberAsyncImagePainter(model = data.imgHash) ,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(4.dp))
                //Main work
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Row(
                        ) {
                            Row {
                                Text(
                                    text = data.Name,
                                    color = cblack ,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                                Text(
                                    text = data.username,
                                    color = cgraystrongest ,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                    )
                                )
                            }

                            Text(
                                text = ". 24d",
                                color = cgraystrongest ,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1.0f))
                        Column {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_more_vert_24) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(16.dp)
                                    .clickable {
                                        expanded = true
                                    } ,
                                tint = cgraystrongest
                            )
                            // drop down menu
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {
                                    expanded = false
                                }
                            ) {
                                // adding items
                                listItems.forEachIndexed { itemIndex, itemValue ->
                                    DropdownMenuItem(
                                        onClick = {
                                            Toast.makeText(contextForToast, itemValue, Toast.LENGTH_SHORT)
                                                .show()

                                            if (itemIndex==0){
                                                //edit post
                                            }

                                            if (itemIndex==1){
                                                //delete
                                                deletePostVM.getDeletePost(postId = data.pstId)
                                            }

                                            if (itemIndex==2){
                                                //report post
                                            }

                                            expanded = false
                                        },
                                        enabled = (itemIndex != disabledItem)
                                    ) {
                                        Text(text = itemValue,)
                                    }
                                }
                            }
                        }
                    }


                    Box() {

                        RichText(
                            modifier = Modifier.padding(16.dp),

                            ) {
                            Markdown(
                                content=data.content,
                            )
                        }


                    }
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        painter = rememberAsyncImagePainter(model = data.imgHash) ,
                        alignment = Alignment.CenterStart,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.comment) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(start = 8.dp) ,

                                )
                            Row {
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                            Text("5")
                        }
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.retweet) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(start = 8.dp) ,

                                )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("5")
                        }
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.like) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(start = 8.dp)
                                    .clickable {
                                        Log.d("1111","like call")
                                        likePostVM.getLikePost(postId = data.pstId)
                                    } ,

                                )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = data.likeCount)
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.views) ,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(start = 8.dp),

                            )
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.share) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(start = 8.dp) ,

                                )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("5")
                        }


                    }
                }


            }
        }
    }


}