package com.danp.danp_lab_02_00.navigation

sealed class AppScreens(val route: String) {
    object PrimeraVentana: AppScreens("firs_screen")
    object SegundaVentana: AppScreens("second_screen")
}
