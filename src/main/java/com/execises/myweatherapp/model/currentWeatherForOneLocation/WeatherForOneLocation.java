package com.execises.myweatherapp.model.currentWeatherForOneLocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForOneLocation implements Serializable {
    private Long id;
    private String name;
    private Long cod;
    @JsonProperty("main") private MainForecastInfo mainForecastInfo;
}
