package com.example.myapplication.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.myapplication.screenui.WalletScreen
import com.example.myapplication.screenui.homeui.ViewPostScreen
import com.example.myapplication.screenui.walletui.CinReceiveScreen
import com.example.myapplication.screenui.walletui.CinSendScreen
import com.example.myapplication.screenui.walletui.PrivateKeyScreen


fun NavGraphBuilder.walletNavGraph(navController: NavHostController){
    navigation(
        route = Graph.WALLET,
        startDestination = Screens.Wallet.route
    ){
        composable(Screens.Wallet.route){
            WalletScreen(navController)
        }
        composable(Screens.CinSendScreen.route){
            CinSendScreen(navController)
        }





        composable(Screens.CinReceiveScreen.route+"/{address}",arguments = listOf(
            navArgument("address")  { type = NavType.StringType } ,
        )
        )
        {
            val address=it.arguments?.getString("address")

            CinReceiveScreen(navController, address = address!!)
        }



        composable(Screens.PrivateKeyScreen.route+"/{privateKey}",arguments = listOf(
            navArgument("privateKey")  { type = NavType.StringType } ,
        )
        )
        {
            val privateKey=it.arguments?.getString("privateKey")

            PrivateKeyScreen(navController, privateKey = privateKey!!)
        }







    }
}