package com.SonarDiveTask.SonarDiveTask.services;

import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public String getName(String isoCode){

        return  isoCode;
    }
}
