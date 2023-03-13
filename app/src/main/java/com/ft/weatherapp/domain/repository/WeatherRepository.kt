package com.ft.weatherapp.domain.repository

import com.ft.weatherapp.domain.util.Resource
import com.ft.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}