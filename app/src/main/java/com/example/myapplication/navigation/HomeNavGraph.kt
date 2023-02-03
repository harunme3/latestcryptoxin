package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.screenui.HomeScreen


fun NavGraphBuilder.homeNavGraph(navController: NavHostController){
   navigation(
       route = Graph.Home,
       startDestination = Screens.Home.route
   ){
       composable(Screens.Home.route){
           HomeScreen()
       }


   }
}