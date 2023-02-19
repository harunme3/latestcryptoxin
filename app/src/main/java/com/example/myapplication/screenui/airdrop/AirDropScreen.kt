package com.example.myapplication.screenui.airdrop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText
import com.halilibo.richtext.ui.RichTextStyle


@Composable
fun AirDropScreen(navController: NavController) {

    val data ="Airdrop :\n" +
            "\n" +
            "\n" +
            "CryptoxIN is Crypto Social Community Which Rewards 1000 coins worth 1 dollar for every Referral.\n" +
            "You can refer as much as you want and can earn rewards from 50 levels from your referrals.\n" +
            "\n" +
            "Whenever downline earns, it's 10% coin is divided into 50 parts and distributed amongst upline.\n" +
            "\n" +
            "\n" +
            "When you refer a friend, both you and your friend earns 1000 CIN coins.\n" +
            "\n" +
            "Keep referring, keep earning.\n" +
            "\n" +
            "All the features of this app goes live on 28th Feb."
    Column() {
        RichText(
            modifier = Modifier.padding(16.dp) ,
            style= RichTextStyle(

            )
        ) {
            Markdown(
                content = data ,
            )
        }
    }
}