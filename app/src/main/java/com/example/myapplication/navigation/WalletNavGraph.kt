package com.example.myapplication.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.myapplication.screenui.VerifyAccount
import com.example.myapplication.screenui.WalletScreen
import com.example.myapplication.screenui.walletui.WalletDashboard


fun NavGraphBuilder.walletNavGraph(navController: NavHostController){
    navigation(
        route = Graph.WALLET,
        startDestination = Screens.Wallet.route
    ){
        composable(Screens.Wallet.route){
            WalletScreen(navController)
        }


        composable(Screens.WalletDashboardScreen.route+"/{walletId}",arguments = listOf(
            navArgument("walletId")  { type = NavType.IntType },
        )
        )
        {
            val walletId=it.arguments?.getInt("walletId")

            WalletDashboard(navController, walletId = walletId!!)
        }

    }
}