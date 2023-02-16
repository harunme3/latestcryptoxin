package com.example.myapplication.screenui.dailycheckin

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.cblack

@Composable
fun DailyCheckInDashboard(navController: NavController){
    Text(text = "Daily check in", color = cblack)
}