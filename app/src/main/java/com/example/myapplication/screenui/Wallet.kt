package com.example.myapplication.screenui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.cgraystronglight
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.ui.theme.cyellow
import com.example.myapplication.uistate.WalletS
import com.example.myapplication.viewmodels.WalletVM

@Composable
fun WalletScreen(navController: NavController,walletVM: WalletVM = hiltViewModel(),){


    val state = walletVM._getAllWalletStateFlow.collectAsState()

    when (state.value) {
        is WalletS.Empty -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(32.dp)),
                    color = cyellow

                )
            }
        }
        is WalletS.Loading -> {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator(
                    modifier = Modifier.then(Modifier.size(64.dp)),
                    color = chonolulublue
                )
            }
        }
        is WalletS.Error -> Text(text = "error")
        is WalletS.Loaded -> {
            val context= LocalContext.current
            val clipboardManager: ClipboardManager = LocalClipboardManager.current
            val data=(state.value as WalletS.Loaded).data


            Box(
            ) {
                LazyColumn(){
                    item {
                        data.forEachIndexed { index, walletEntity ->
                            WalletCard(walletEntity,navController,walletVM)
                        }
                    }
                }

              ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                  val floatingActionButton=createRef()
                  FloatingActionButton(
                      modifier=Modifier.padding(bottom = 64.dp, end = 8.dp).constrainAs(floatingActionButton){
                          end.linkTo(parent.end)
                         bottom.linkTo(parent.bottom)


                      },
                      backgroundColor = chonolulublue,
                      onClick = { /*TODO*/ },
                  ) {
                      Icon(
                          imageVector = Icons.Rounded.Add,
                          contentDescription = "Add FAB",
                          tint = Color.White,
                      )
                  }
              }
            }


        }


    }

}




@Composable
fun WalletCard( walletEntity: WalletEntity , navController: NavController , walletVM: WalletVM) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {
                navController.navigate(Screens.WalletDashboardScreen.route + "/${walletEntity.walletId}")
            }),
        elevation = 0.dp,
        backgroundColor = cgraystronglight
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    painter = painterResource(id =com.example.myapplication.R.drawable.cdarklogo),
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Column( Modifier
                    .weight(1f)) {
                    Text(
                        text =walletEntity.walletId.toString(),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,
                        style = typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text =walletEntity.address,
                        modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                        color = cwhite,
                        style = typography.caption
                    )
                }




            Icon(
                painter = painterResource(id = com.example.myapplication.R.drawable.ic_baseline_more_vert_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Red
            )
        }
    }
}

