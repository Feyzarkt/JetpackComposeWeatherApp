package com.feyzaurkut.weatherapp.presentation.daily

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.feyzaurkut.weatherapp.domain.weather.WeatherData
import com.feyzaurkut.weatherapp.presentation.home.HourlyWeatherDisplay
import java.time.format.DateTimeFormatter

@Composable
fun DailyWeatherDisplay(
    weatherData: List<WeatherData>,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Card(
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(16.dp),
    ) {
        Column(
            modifier = modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val maxTemp = weatherData.maxOf { it.temperatureCelsius }
            val minTemp = weatherData.minOf { it.temperatureCelsius }
            val formattedDate = remember(weatherData) {
                weatherData[0].time.format(
                    DateTimeFormatter.ofPattern("dd, MMM yyyy")
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = formattedDate,
                    color = Color.White
                )
                Text(
                    text = "Max: $maxTemp °C",
                    color = Color.White
                )
            }

            Text(
                text = "Min: $minTemp °C",
                modifier = Modifier.align(Alignment.End),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(weatherData) { weatherData ->
                    HourlyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }
}