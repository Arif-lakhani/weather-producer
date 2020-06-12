package com.egen.Weather.service;

import com.egen.Weather.model.Weather;
import com.egen.Weather.model.WeatherAlert;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface WeatherService {
    boolean addWeatherReadings(Weather weather) throws JsonProcessingException;
     List<Weather> getWeatherReadingsSorted() ;
}
