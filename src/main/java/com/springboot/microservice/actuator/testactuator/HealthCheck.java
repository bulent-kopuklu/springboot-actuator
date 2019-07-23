package com.springboot.microservice.actuator.testactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HealthCheck implements HealthIndicator
{
    @Override
    public Health health()
    {
        int error = check();
        if (error != 0)
        {
            return Health.down().withDetail("Error Code", error).build();
        }

        return Health.up().build();
    }

    private int check()
    {
        return new Random().nextInt(2);
    }
}
