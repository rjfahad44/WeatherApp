package com.ft.weatherapp.data.repository

import com.ft.weatherapp.data.mappers.toWeatherInfo
import com.ft.weatherapp.data.remote.WeatherApi
import com.ft.weatherapp.domain.repository.WeatherRepository
import com.ft.weatherapp.domain.util.Resource
import com.ft.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}