package com.execises.myweatherapp.service;

import com.execises.myweatherapp.model.currentWeatherForOneLocation.WeatherForOneLocation;

public interface IWeatherForOneLocationService {
    WeatherForOneLocation getCurrentWeatherForOneLocationByCityName(String cityName);
}
