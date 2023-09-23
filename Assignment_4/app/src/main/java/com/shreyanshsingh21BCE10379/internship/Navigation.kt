package com.shreyanshsingh21BCE10379.internship

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "LoginScreen") {
        composable(route = "LoginScreen") {
            LoginScreen(navController = navController)
        }
        composable(route = "RestaurantList") {
            RestaurantList(navController = navController)
        }
        composable(
            route = "Menu" + "/{restaurant}",
            arguments = listOf(navArgument("restaurant") {
                type = NavType.StringType
                nullable = false
            })
        ) { entry ->
            entry.arguments?.getString("restaurant")?.let {
                Menu(
                    navController = navController,
                    restaurant = it
                )
            }
        }
    }
}