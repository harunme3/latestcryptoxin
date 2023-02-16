package com.example.myapplication.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.screenui.WalletScreen
import com.example.myapplication.screenui.profilescreen.FollowerScreen
import com.example.myapplication.screenui.profilescreen.FollowingScreen


fun NavGraphBuilder.walletNavGraph(navController: NavHostController){
    navigation(
        route = Graph.WALLET,
        startDestination = Screens.Wallet.route
    ){
        composable(Screens.Wallet.route){
            WalletScreen(navController)
        }


        composable(Screens.FollowerScreen.route){
           FollowerScreen(navController)
        }


        composable(Screens.FollowingScreen.route){
            FollowingScreen(navController)
        }

    }
}