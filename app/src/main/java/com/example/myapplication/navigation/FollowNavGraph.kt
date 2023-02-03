package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.screenui.FollowScreen
import com.example.myapplication.screenui.HomeScreen



fun NavGraphBuilder.followNavGraph(navController: NavHostController){
    navigation(
        route = Graph.FOLLOW,
        startDestination = Screens.Follow.route
    ){
        composable(Screens.Follow.route){
            FollowScreen()
        }

    }
}