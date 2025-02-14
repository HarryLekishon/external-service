package com.restemplate.countryapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restemplate.countryapi.entity.Countries;
import com.restemplate.countryapi.entity.DataResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityController {
    List<Countries> countries = new ArrayList<>();
    @GetMapping("/cities")
    public List<Countries> getCountryDetails(){
        String uri = "https://countriesnow.space/api/v0.1/countries";
        RestTemplate template = new RestTemplate();
        Object[] objetcs = new Object[]{template.getForObject(uri, Object.class)};

        ObjectMapper objectMapper = new ObjectMapper();
         countries= Arrays.stream(objetcs).map(o -> objectMapper.convertValue(o, DataResponse.class))
                .map(DataResponse::getData)
                .collect(Collectors.toList()).get(0);

        return countries;
    }

    @GetMapping("/city")
    public List<Countries> getCity(){
        return countries.stream().filter(e->e.getCountry().equals("Kenya")).collect(Collectors.toList());
    }

}
