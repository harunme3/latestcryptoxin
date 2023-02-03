package com.example.myapplication.screenui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.data.datasource.roomdata.WalletEntity
import com.example.myapplication.navigation.Graph
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.*
import com.example.myapplication.viewmodels.CreateWalletViewModels


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VerifyAccount(navController: NavController,  mnemonic: String, privateKey: String, address: String,createWalletViewModels: CreateWalletViewModels = hiltViewModel()) {

    val context=LocalContext.current
    val mnemonicList=mnemonic.split(" ").toList()

    val  totalMnemonicList : MutableList<String> = remember {
        mnemonicList.shuffled().toMutableList()
    }

    val selectedMnemonicList : MutableList<String> = remember {
        mutableStateListOf()
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
         verticalArrangement = Arrangement.SpaceBetween,)
    {
        Column( horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Verify Secret Phrase",
                style = TextStyle(
                    color = cblack,
                    fontSize = 24.sp

                ),
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = "Tap the words to put them next to each other in the correct order",
                style = TextStyle(
                    color = cblack,
                    fontSize = 14.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                FlowRow(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    maxItemsInEachRow = 4
                ) {
                    selectedMnemonicList.forEachIndexed  { index,it ->
                        Box(modifier = Modifier.padding(2.dp)) {
                            Text(
                                text = "${index + 1} $it",
                                modifier = Modifier
                                    .background(
                                        color = cgraylight,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .padding(8.dp),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                }



            }

            if ( selectedMnemonicList.size==12 ){

                if (listsEqual(selectedMnemonicList,mnemonicList))
                    Text(text = "well done",color= cgreenmostlight)
                else
                    Text(text = "wrong phrase", color = credstronglight )
            }

         Box(modifier = Modifier.fillMaxHeight(0.1f))

            Box(
                modifier = Modifier
                    .background(color = if (totalMnemonicList.isEmpty()) Color.Transparent else cyellow.copy(alpha = 0.1f))
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                FlowRow(
                    modifier = Modifier.padding(4.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    maxItemsInEachRow = 4
                ) {
                    totalMnemonicList.forEachIndexed  { index,it ->
                        Box(modifier = Modifier.padding(2.dp)) {
                            Text(
                                text = it,
                                modifier = Modifier
                                    .background(
                                        color = cyellow,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .padding(8.dp)
                                    .clickable {
                                        selectedMnemonicList.add(it)
                                        totalMnemonicList.remove(it)

                                    },
                                color= cwhite,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                }
            }

        }

        if ( selectedMnemonicList.size==12 && listsEqual(selectedMnemonicList,mnemonicList)){
            Column{
                Button(
                    onClick = {
                //Room database implementation and navigate to dashboard

                        Log.d("1111","$mnemonic $privateKey $address")
                        createWalletViewModels.createWallet(WalletEntity(null,mnemonicPhrase=mnemonic,privateKey=privateKey,address=address))
                        Toast.makeText(context, "Welcome to CryptoxIN", Toast.LENGTH_SHORT).show()
                        navController.navigate(Graph.DASHBOARD)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = chonolulublue)
                )
                {
                    Text(
                        text = "Done",
                        style = TextStyle(
                            color = cwhite,
                            fontSize = 18.sp

                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

                }
            }
        }

    }


}

fun listsEqual(list1: List<Any>, list2: List<Any>): Boolean {

    if (list1.size != list2.size)
        return false

    val pairList = list1.zip(list2)

    return pairList.all { (elt1, elt2) ->
        elt1 == elt2
    }
}