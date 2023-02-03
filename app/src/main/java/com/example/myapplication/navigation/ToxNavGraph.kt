package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.screenui.HomeScreen
import com.example.myapplication.screenui.ToxScreen



fun NavGraphBuilder.toxNavGraph(navController: NavHostController){
    navigation(
        route = Graph.TOX,
        startDestination = Screens.Tox.route
    ){
        composable(Screens.Tox.route){
            ToxScreen()
        }

    }
}