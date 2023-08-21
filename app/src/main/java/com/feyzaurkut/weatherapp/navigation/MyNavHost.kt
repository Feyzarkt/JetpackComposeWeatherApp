package com.feyzaurkut.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.feyzaurkut.weatherapp.presentation.WeatherState
import com.feyzaurkut.weatherapp.presentation.daily.DailyWeatherForecast
import com.feyzaurkut.weatherapp.presentation.home.WeatherHome

@Composable
fun MyNavHost(
    state: WeatherState,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "weatherForecast"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("weatherForecast") {
            WeatherHome(
                onNavigateToDaily = { navController.navigate("dailyWeatherForecast") },
                state
            )
        }
        composable("dailyWeatherForecast") {
            DailyWeatherForecast(state)
        }
    }
}