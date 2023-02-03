package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun DashBoardNavGraph(navController: NavHostController, modifier: Modifier){
    NavHost(
        navController = navController,
        route=Graph.DASHBOARD,
        startDestination = Graph.Home,
    ){
        homeNavGraph(navController = navController)
        followNavGraph(navController = navController)
        toxNavGraph(navController = navController)
        walletNavGraph(navController = navController)
        profileNavGraph(navController = navController)
    }


}