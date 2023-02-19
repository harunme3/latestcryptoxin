package com.example.myapplication.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.screenui.FollowScreen
import com.example.myapplication.screenui.airdrop.AirDropScreen
import com.example.myapplication.screenui.profilescreen.FollowerScreen
import com.example.myapplication.screenui.profilescreen.FollowingScreen


fun NavGraphBuilder.followNavGraph(navController: NavHostController){
    navigation(
        route = Graph.FOLLOW,
        startDestination = Screens.Follow.route
    ){
        composable(Screens.Follow.route){
            FollowScreen(navController)
        }

        composable(Screens.AirDropScreen.route){
            AirDropScreen(navController)
        }

        composable(Screens.FollowerScreen.route){
            FollowerScreen(navController)
        }


        composable(Screens.FollowingScreen.route){
            FollowingScreen(navController)
        }

    }
}