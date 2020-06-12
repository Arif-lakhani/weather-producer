package com.egen.Weather.service.impl;


import com.egen.Weather.awsMessaging.WeatherAlertsSns;
import com.egen.Weather.model.Weather;
import com.egen.Weather.model.WeatherAlert;
import com.egen.Weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DefaultWeatherService implements WeatherService {

//    List<Weather> list = new LinkedList<>();


    private WeatherAlertsSns weatherAlertsSns;

    private ObjectMapper objectMapper;


    @Autowired
    public DefaultWeatherService( WeatherAlertsSns weatherAlertsSns, ObjectMapper objectMapper){
        this.weatherAlertsSns=weatherAlertsSns;
        this.objectMapper = objectMapper;

    }

    @Override
    public boolean addWeatherReadings(Weather weather) throws JsonProcessingException {
        //if weather alert is created then we return true. if not false;
        WeatherAlert weatherAlert = null;
    if(weather.getTemperature()>25){
              weatherAlert = new WeatherAlert("Too Hot",weather);
            String message = objectMapper.writeValueAsString(weatherAlert);
            System.out.println(message);
            weatherAlertsSns.send("Temperature Alert",message);
//           return restTemplate.postForObject("http://localhost:8081/addReading",weatherAlert,boolean.class);

        }
        if(weather.getWind().getSpeed()>6){
              weatherAlert = new WeatherAlert("Too Windy", weather);
//             restTemplate.postForObject("http://localhost:8081/addReading",weatherAlert,boolean.class);
            String message = objectMapper.writeValueAsString(weatherAlert);
            weatherAlertsSns.send("Wind Alert",message);

        }
        return weatherAlert!=null;
    }

    @Override
    public List<Weather> getWeatherReadingsSorted() {
//        List<Weather> weatherList = (List<Weather>) weatherRepository.findAll();
//         weatherList.sort(Comparator.comparing(Weather::getTimestamp));
         return null;
    }
}
