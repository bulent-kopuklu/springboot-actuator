package com.springboot.microservice.actuator.testactuator;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RestControllerEndpoint(id = "costum-rest-endpoint")
public class RestCostumEndpoint
{

    @GetMapping
    public Map<String, String> customEndPoint()
    {
        Map<String, String> map = new HashMap<>();
        map.put("server.date", LocalDate.now().toString());
        map.put("server.time", LocalTime.now().toString());
        return map;
    }

    @GetMapping("{name}")
    public Map<String, String> customEndPointByName(@PathVariable("name") String name)
    {
        Map<String, String> map = new HashMap<>();
        if (name.equals("server.date"))
            map.put("server.date", LocalDate.now().toString());
        else
            map.put("server.time", LocalTime.now().toString());
        return map;
    }

    @PostMapping
    public String post(@RequestBody String request)
    {
        return "We have received your request: " + request;
    }
}
