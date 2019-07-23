package com.springboot.microservice.actuator.testactuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Endpoint(id="costum-endpoint")
public class CostumCounterEndpoint
{
    Logger logger = LoggerFactory.getLogger(CostumCounterEndpoint.class);

    int i0;
    int i1;

    @Data
    @AllArgsConstructor
    public static class HealthData
    {
        private Map<String, Integer> ints;
    }

    @ReadOperation
    public HealthData health()
    {
        logger.info("readOperation");


        Map<String, Integer> h = new LinkedHashMap<>();
        if (i0 != -1)
            h.put("i0", ++i0);
        if (i1 != -1)
            h.put("i1", ++i1);

        return new HealthData(h);
    }

    @ReadOperation
    public HealthData readOperationByName(@Selector String name)
    {
        logger.info("readOperationByName name:{}", name);

        Map<String, Integer> h = new LinkedHashMap<>();
        if (name.equals("i0") && i0 != -1)
        {
            h.put("i0", ++i0);
        }
        else if (i1 != -1)
        {
            h.put("i0", ++i1);
        }

        return new HealthData(h);
    }

    @WriteOperation
    public void resetOperation(@Selector String name)
    {
        logger.info("resetOperationByName name:{}", name);
        if (name.equals("i0"))
        {
            i0 = 0;
        }
        else
        {
            i1 = 0;
        }

    }

    @DeleteOperation
    public void deleteOperation(@Selector String name)
    {
        logger.info("deleteOperationByName name:{}", name);

        if (name.equals("i0"))
        {
            i0 = -1;
        }
        else
        {
            i1 = -1;
        }

    }

}
