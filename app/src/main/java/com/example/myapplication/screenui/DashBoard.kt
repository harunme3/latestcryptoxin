package com.example.myapplication.screenui
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.DashBoardNavGraph
import com.example.myapplication.ui.theme.chonolulublue
import com.example.myapplication.ui.theme.cwhite
import com.example.myapplication.utilities.BottomNavigationBar


@Composable
fun DashBoardScreen(navController:NavHostController= rememberNavController()){

    Scaffold(
        topBar = {
        TopAppBar(
            backgroundColor = chonolulublue,
            contentColor = cwhite
            ) {
            Text(text = "DashBoard")
        }
    },
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