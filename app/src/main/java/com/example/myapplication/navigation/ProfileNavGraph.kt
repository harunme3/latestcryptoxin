package com.example.myapplication.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.screenui.ProfileScreen
import com.example.myapplication.screenui.aboutus.AboutUsScreen
import com.example.myapplication.screenui.airdrop.AirDropScreen
import com.example.myapplication.screenui.profilescreen.EditProfile
import com.example.myapplication.screenui.profilescreen.ProfileImageUpdateScreen


fun NavGraphBuilder.profileNavGraph(navController: NavHostController){
    navigation(
        route = Graph.PROFILE,
        startDestination = Screens.Profile.route
    ){

        composable(Screens.Profile.route){
            ProfileScreen(navController)
        }

        composable(Screens.EditProfile.route){
            EditProfile(navController)
        }

        composable(Screens.ProfileImageUpdateScreen.route){
           ProfileImageUpdateScreen(navController)
        }

        composable(Screens.AboutUsScreen.route){
            AboutUsScreen(navController)
        }

        composable(Screens.AirDropScreen.route){
            AirDropScreen(navController)
        }

    }
}