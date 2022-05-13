package com.danp.danp_lab_02_00.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.danp.danp_lab_02_00.screens.PrimeraVentana
import com.danp.danp_lab_02_00.screens.SegundaVentana


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.PrimeraVentana.route) {
        composable(route = AppScreens.PrimeraVentana.route) {
            PrimeraVentana(navController)
        }
        composable(route = AppScreens.SegundaVentana.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })) {
            SegundaVentana(navController, it.arguments?.getString("text"))
        }
    }
}