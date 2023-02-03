package com.example.myapplication.screenui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.cgraystronglight
import com.example.myapplication.ui.theme.chonolulublue


@Composable
fun HomeScreen() {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),

        elevation = 0.dp,
        backgroundColor = cgraystronglight
    ) {
        Row(modifier = Modifier.padding(horizontal = 4.dp)) {

            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.dummyprofilephoto),
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
          Spacer(modifier = Modifier.width(4.dp))
            Column(verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()) {

                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Praveen @we- 20 days",

                        color = MaterialTheme.colors.surface,
                        style = MaterialTheme.typography.subtitle1,
                        maxLines = 1
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Red
                    )
                }

                Box(modifier = Modifier.weight(1f)){
                    Text(
                        text = "Post",
                        modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                        color = MaterialTheme.colors.surface,
                        style = MaterialTheme.typography.caption

                    )
                }

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_add_photo_alternate_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(start = 8.dp),
                        tint = chonolulublue
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_videocam_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(start = 8.dp),
                        tint = chonolulublue
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_bar_chart_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(start = 8.dp),
                        tint = chonolulublue
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_text_fields_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(start = 8.dp),
                        tint = chonolulublue
                    )


                }
            }


        }
    }

}