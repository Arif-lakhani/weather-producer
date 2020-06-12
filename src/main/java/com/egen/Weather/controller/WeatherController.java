package com.egen.Weather.controller;

import com.egen.Weather.model.Weather;
import com.egen.Weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private  WeatherService weatherService;

    @Autowired
    public  WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping
    @ApiOperation(value = "A Simple demo get method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public String mySimpleGetMethod(){
    return "My Simple method";
    }

    @PostMapping("/addReading")
    @ApiOperation(value = "Create/Add new Weather Readings.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Added"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public boolean addWeatherReadings(@RequestBody Weather weather) throws JsonProcessingException {
       weatherService.addWeatherReadings(weather);
        return true;
    }

    @GetMapping("/sortedReadings")
    @ApiOperation(value = "Get all Weather Readings sorted based on time Stamp")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Added"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Weather> getAll(){
        return weatherService.getWeatherReadingsSorted();
    }



}
