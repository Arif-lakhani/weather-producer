package com.egen.Weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherAlert {
    private String alert;
    private Weather weather;
}
