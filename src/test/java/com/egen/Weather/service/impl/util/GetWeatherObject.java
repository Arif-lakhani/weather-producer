package com.egen.Weather.service.impl.util;

import com.egen.Weather.model.Weather;
import com.egen.Weather.model.Wind;

public class GetWeatherObject {
    public static Weather getWeatherObject(){
        return new Weather("chicago","sunny",
                90.0,1009.0,22,new Wind(),null);
    }
    public static Weather getWeatherObjectTemp(){
        return new Weather("chicago","sunny",
                90.0,1009.0,26,new Wind(),null);
    }
    public static Weather getWeatherObjectWind(){
        return new Weather("chicago","sunny",
                90.0,1009.0,26,new Wind(7.0,233),null);
    }
}
