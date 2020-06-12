package com.egen.Weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {
    private double speed;
    private double degree;

}
/*
 "speed": 3.1,
    "degree": 240
 */