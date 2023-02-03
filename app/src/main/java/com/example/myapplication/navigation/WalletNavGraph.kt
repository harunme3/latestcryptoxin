package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.screenui.HomeScreen
import com.example.myapplication.screenui.WalletScreen



fun NavGraphBuilder.walletNavGraph(navController: NavHostController){
    navigation(
        route = Graph.WALLET,
        startDestination = Screens.Wallet.route
    ){
        composable(Screens.Wallet.route){
            WalletScreen()
        }

    }
}