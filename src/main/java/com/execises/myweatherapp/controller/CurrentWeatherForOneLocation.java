package com.execises.myweatherapp.controller;

import com.execises.myweatherapp.model.currentWeatherForOneLocation.WeatherForOneLocation;
import com.execises.myweatherapp.service.IWeatherForOneLocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/current/weather")
@Api(value = "Current weather for one location")
public class CurrentWeatherForOneLocation {

    private final IWeatherForOneLocationService weatherForOneLocationService;

    @Autowired
    public CurrentWeatherForOneLocation(final IWeatherForOneLocationService weatherForOneLocationService) {
        this.weatherForOneLocationService = weatherForOneLocationService;
    }

    @ApiOperation(value = "Get weather by city name")
    @GetMapping(
            path = "/city/{cityName}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public WeatherForOneLocation getCurrentWeatherByCityName(@PathVariable String cityName) {
        return weatherForOneLocationService.getCurrentWeatherForOneLocationByCityName(cityName);
    }
}
