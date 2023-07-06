package com.plcoding.weatherapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.weatherapp.presentation.WeatherState
import com.plcoding.weatherapp.presentation.ui.theme.DarkBlue
import com.plcoding.weatherapp.presentation.ui.theme.DeepBlue

@Composable
fun WeatherHome(onNavigateToDaily: () -> Unit, state: WeatherState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        WeatherCard(
            state = state,
            backgroundColor = DeepBlue
        )
        Spacer(modifier = Modifier.height(16.dp))
        WeatherForecast(onNavigateToDaily = { onNavigateToDaily() }, state = state)
    }
}