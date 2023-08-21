package com.feyzaurkut.weatherapp.domain.repository

import com.feyzaurkut.weatherapp.domain.util.Resource
import com.feyzaurkut.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}