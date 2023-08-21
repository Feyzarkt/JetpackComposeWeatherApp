package com.feyzaurkut.weatherapp.presentation.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.feyzaurkut.weatherapp.presentation.WeatherState
import com.feyzaurkut.weatherapp.presentation.ui.theme.DarkBlue
import com.feyzaurkut.weatherapp.presentation.ui.theme.DeepBlue

@Composable
fun DailyWeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.let { data ->
        LazyColumn(modifier = modifier.fillMaxSize().background(DarkBlue)) {
            items(data.values.toList()) { weatherData ->
                DailyWeatherDisplay(
                    weatherData = weatherData,
                    backgroundColor = DeepBlue
                )
            }
        }
    }
}