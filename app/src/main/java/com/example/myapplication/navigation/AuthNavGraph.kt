package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.myapplication.screenui.*


fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screens.SplashScreen.route
    ){
        composable(Screens.SplashScreen.route){
            SplashScreen(navController)
        }

        composable(Screens.CreateImport.route){
            CreateImport(navController)
        }

        composable(Screens.CreateAccount.route){
            CreateAccount(navController)
        }

        composable(Screens.ImportAccount.route){
            ImportAccount(navController)
        }

        composable(Screens.MandatoryDetails.route){
            MandatoryDetails(navController)
        }


        composable(Screens.ReferralScreen.route+"/{mnemonic}/{privateKey}/{address}",arguments = listOf(
            navArgument("mnemonic")  { type = NavType.StringType },
            navArgument("privateKey")  { type = NavType.StringType },
            navArgument("address")  { type = NavType.StringType },
        )
        )
        {
            val mnemonic=it.arguments?.getString("mnemonic")
            val privateKey=it.arguments?.getString("privateKey")
            val address=it.arguments?.getString("address")
            ReferralScreen(navController, mnemonic = mnemonic!!, privateKey = privateKey!!, address = address!!)
        }


        composable(Screens.VerifyAccount.route+"/{mnemonic}/{privateKey}/{address}",arguments = listOf(
            navArgument("mnemonic")  { type = NavType.StringType },
            navArgument("privateKey")  { type = NavType.StringType },
            navArgument("address")  { type = NavType.StringType },
        )
        )
        {
            val mnemonic=it.arguments?.getString("mnemonic")
            val privateKey=it.arguments?.getString("privateKey")
            val address=it.arguments?.getString("address")
            VerifyAccount(navController, mnemonic = mnemonic!!, privateKey = privateKey!!, address = address!!)
        }

    }
}