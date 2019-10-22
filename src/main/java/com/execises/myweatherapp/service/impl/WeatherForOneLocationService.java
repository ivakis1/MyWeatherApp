package com.execises.myweatherapp.service.impl;

import com.execises.myweatherapp.model.currentWeatherForOneLocation.WeatherForOneLocation;
import com.execises.myweatherapp.service.IWeatherForOneLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

//TODO: Please, find out what is @Slf4j
@Service
@Slf4j
public class WeatherForOneLocationService implements IWeatherForOneLocationService {

    //TODO: What is @Value
    @Value("${api_url}")
    private String CURRENT_WEATHER_BY_CITY_NAME;

    @Value("${app_id}")
    private String appId;

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherForOneLocationService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherForOneLocation getCurrentWeatherForOneLocationByCityName(final String cityName) {
        //TODO: It is good that we log current action. Please, find out where does this logger logs messages
        log.info("Getting current weather for cityName {}", cityName);

        WeatherForOneLocation response = null;

        final String currentWeatherForOneLocationUrl =
                CURRENT_WEATHER_BY_CITY_NAME + "q={cityName}&appid={appId}";
        try {
            response = restTemplate
                    .getForEntity(currentWeatherForOneLocationUrl,
                            WeatherForOneLocation.class, cityName, appId)
                    .getBody();
        } catch (HttpClientErrorException ex) {
            log.error("Could not get current weather for cityName {}", cityName, ex);
        }
        log.info("Successfully got current weather for cityName {}, with body {}", cityName,
                response != null ? response.toString() : null);

        return response;
    }
}
