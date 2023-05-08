package com.plcoding.weatherapp.domain.weather

import java.time.LocalDateTime

// her bir gün için model sınıfı, mapperda hours datası parçalanıyor bu şekilde
data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)