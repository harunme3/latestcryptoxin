package com.example.myapplication.screenui
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.*


@Composable
fun FollowScreen(){



LazyColumn(){
    item {
        (1..8).forEach {
            FollowCard()
        }
    }
}


}




//----------------New card------------------------//




@Composable
fun FollowCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {
                //Navigate to profile
            }),
        elevation = 0.dp,
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
                    .size(80.dp)
                    .clip(CircleShape),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = "Praveen",
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = buildString {
                        append("@prvks")
                        append("yrs | ")
                        append("male")
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = cwhite,
                    style = MaterialTheme.typography.caption
                )

                Row(verticalAlignment = Alignment.Bottom) {

                    val location: Painter = painterResource(id = R.drawable.home)

                    Icon(
                        painter = location,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp, 16.dp),
                        tint = Color.Red
                    )

                    Text(
                        text = "Entrepreneur",
                        modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                        color = MaterialTheme.colors.surface,
                        style = MaterialTheme.typography.caption

                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically

            ) {
                GenderTag("Follow")
            }
        }
    }
}

@Composable
fun GenderTag(name: String) {
    val color = if (name == "Male") chonolulublue else credstronglight
    ChipView(gender = name, colorResource=color)
}

@Composable
fun ChipView(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = gender, modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}

