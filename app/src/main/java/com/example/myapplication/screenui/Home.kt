package com.example.myapplication.screenui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.ui.theme.cblack
import com.example.myapplication.ui.theme.cgraystrongest
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.AllPostS
import com.example.myapplication.viewmodels.AllPostVM
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.markdown.MarkdownParseOptions
import com.halilibo.richtext.ui.HeadingStyle
import com.halilibo.richtext.ui.RichText
import com.halilibo.richtext.ui.RichTextScope
import com.halilibo.richtext.ui.RichTextStyle

@Composable
fun HomeScreen(allPostVM: AllPostVM= hiltViewModel()) {

    val state = allPostVM._getAllPostStateFlow.collectAsState()
    when (state.value) {
        is AllPostS.Empty -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(32.dp)),
                    color = cyellow

                )
            }
        }
        is AllPostS.Loading -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(64.dp)),
                    color = chonolulublue
                )
            }
        }
        is AllPostS.Error -> Text(text = "error")
        is AllPostS.Loaded -> {
            val context= LocalContext.current
            val clipboardManager: ClipboardManager = LocalClipboardManager.current
            val data=(state.value as AllPostS.Loaded).data.data


            LazyColumn(){
                item {
                    data.forEachIndexed { index, it ->
                 AllPostCard(
                     author = it.author,
                     hashtag =it.hashtag ,
                     content =it.content ,
                     imgHash =it.imgHash ,
                     timestamp =it.timestamp ,
                     likeCount = it.likeCount
                 )
                    }
                }
            }


        }


    }


}
















    @Composable
    fun AllPostCard(
        author:String,
        hashtag:String,
        content:String,
        imgHash:String,
        timestamp:String,
        likeCount:String,
    ){




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
                    painter = rememberAsyncImagePainter(model = imgHash),
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
                                    text = "Praveen Kumar Sahani",
                                    color = cblack,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                                Text(
                                    text = "@prkv",
                                    color = cgraystrongest,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                    )
                                )
                            }

                            Text(
                                text = ". 24d",
                                color = cgraystrongest,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1.0f))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = cgraystrongest
                        )
                    }

                    Box() {

                        RichText(
                            modifier = Modifier.padding(16.dp),

                        ) {
                            Markdown(
                                content=content,
                            )
                        }


                    }
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        painter = rememberAsyncImagePainter(model = imgHash),
                        alignment = Alignment.CenterStart,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.comment),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(start = 8.dp),

                            )
                        Icon(
                            painter = painterResource(id = R.drawable.retweet),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(start = 8.dp),

                            )
                        Icon(
                            painter = painterResource(id = R.drawable.like),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(start = 8.dp),

                            )
                        Icon(
                            painter = painterResource(id = R.drawable.views),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(start = 8.dp),

                            )
                        Icon(
                            painter = painterResource(id = R.drawable.share),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(start = 8.dp),

                            )


                    }
                }


            }
        }
    }
}

