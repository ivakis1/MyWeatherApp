package com.execises.myweatherapp.model.currentWeatherForOneLocation;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MainForecastInfo implements Serializable {
    private Double temp;
    private Double pressure;
    private Double humidity;
    @JsonProperty("temp_min") private Double tempMin;
    @JsonProperty("temp_max")  private Double tempMax;
}
