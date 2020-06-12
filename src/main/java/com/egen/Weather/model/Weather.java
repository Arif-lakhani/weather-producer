package com.egen.Weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private  String city;
    private String description;
    private double humidity;
    private double pressure;
    private double temperature;
    private Wind wind;
    private Timestamp timestamp;

}
/*
{
  "city": "Chicago",
  "description": "scattered clouds",
  "humidity": 33,
  "pressure": 1020,
  "temperature": 25, (>25)
  "wind": {
    "speed": 3.1, (>6)
    "degree": 240
  },
  "timestamp": "2017-02-14T05:48:41.861Z"
}
 */