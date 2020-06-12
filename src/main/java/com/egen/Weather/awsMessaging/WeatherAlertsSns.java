package com.egen.Weather.awsMessaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class WeatherAlertsSns {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    @Value("${wather.alert.topic}")
    private String topic ;

    @Autowired
    public WeatherAlertsSns(NotificationMessagingTemplate notificationMessagingTemplate) {
        this.notificationMessagingTemplate =notificationMessagingTemplate;
    }

    public void send(String subject, String message) {
        this.notificationMessagingTemplate.sendNotification(topic, message, subject);
    }
}