package com.example.myapplication.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.myapplication.screenui.HomeScreen
import com.example.myapplication.screenui.createImport.MandatoryDetails
import com.example.myapplication.screenui.homeui.CreateCommentScreen
import com.example.myapplication.screenui.homeui.ViewPostDetailsScreen
import com.example.myapplication.screenui.homeui.ViewPostScreen


fun NavGraphBuilder.homeNavGraph(navController: NavHostController){
   navigation(
       route = Graph.Home,
       startDestination = Screens.Home.route
   ){
       composable(Screens.Home.route){
           HomeScreen(navController)
       }




       composable(Screens.CreateCommentScreen.route+"/{postId}",arguments = listOf(
           navArgument("postId")  { type = NavType.StringType } ,
       )
       )
       {
           val postId=it.arguments?.getString("postId")

           CreateCommentScreen(navController, postId = postId!!)
       }




       composable(Screens.ViewPostScreen.route+"/{postId}",arguments = listOf(
           navArgument("postId")  { type = NavType.StringType } ,
       )
       )
       {
           val postId=it.arguments?.getString("postId")

           ViewPostScreen(navController, postId = postId!!)
       }


       composable(Screens.ViewPostDetailsScreen.route){
           ViewPostDetailsScreen(navController)
       }


   }
}