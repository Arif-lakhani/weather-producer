package com.egen.Weather.service.impl;

import com.egen.Weather.awsMessaging.WeatherAlertsSns;
import com.egen.Weather.model.WeatherAlert;
import com.egen.Weather.service.impl.util.GetWeatherObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultWeatherServiceTest {

    private DefaultWeatherService defaultWeatherService;

    @Mock
    private WeatherAlertsSns weatherAlertsSns;

    @Mock
    private ObjectMapper objectMapper;

    @Before
    public void setup(){
        defaultWeatherService = new DefaultWeatherService(weatherAlertsSns,objectMapper);
    }

    @Test
    public void addWeatherNormalReadings() throws JsonProcessingException {
        boolean b = defaultWeatherService.addWeatherReadings(GetWeatherObject.getWeatherObject());
        Assert.assertFalse(b);
    }
    @Test
    public void addWeatherTemperature() throws JsonProcessingException {
        Mockito.when(objectMapper.writeValueAsString(ArgumentMatchers.any(WeatherAlert.class))).thenReturn("Hello world");
        boolean b = defaultWeatherService.addWeatherReadings(GetWeatherObject.getWeatherObjectTemp());
        Assert.assertTrue(b);
    }

    @Test
    public void addWeatherWind() throws JsonProcessingException {
        Mockito.when(objectMapper.writeValueAsString(ArgumentMatchers.any(WeatherAlert.class))).thenReturn("Hello world");
        boolean b = defaultWeatherService.addWeatherReadings(GetWeatherObject.getWeatherObjectWind());
        Assert.assertTrue(b);
    }
}