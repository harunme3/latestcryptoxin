package com.example.myapplication.screenui
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.DashBoardNavGraph
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.utilities.BottomNavigationBar


@Composable
fun DashBoardScreen(navController:NavHostController= rememberNavController()){

    Scaffold(

        bottomBar = {
            BottomNavigationBar(navController=navController)
        }

    ){
        DashBoardNavGraph(
            navController= navController,
            modifier = Modifier.padding(it)
        )
    }
}