package com.covid.controller;

import com.covid.dto.CountryDto;
import com.covid.dto.CovidDto;
import com.covid.service.Covid19Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

@RestController
class  Covid19Controller{

    @Autowired
    Covid19Service covid19Service;

    /**
     * THIS API FOR GETTING STATISTICS OF COVID 19 PER COUNTRY
     * @param country
     * @return CovidDto
     */
    @GetMapping("api/live/covid/{country}")
    public ResponseEntity<List<CovidDto>> getCovidStatisticsPerCountry(@PathVariable("country") String country){
         final List<CovidDto> covidDtoList =covid19Service.getCovidStatisticsPerCountry(country);
        return new ResponseEntity<>(covidDtoList, HttpStatus.OK);
    }

    /**
     * THIS API FOR GETTING All COUNTRY
     * @return CovidDto
     */
    @GetMapping("api/all/countries")
    public ResponseEntity<List<CountryDto>> getAllCountries(){
        List<CountryDto> countriesDtos=covid19Service.getAllCountries();
        return new ResponseEntity<>(countriesDtos, HttpStatus.OK);
    }


    /**
     * THIS API FOR GETTING All COUNTRY
     * @return CovidDto
     */
    @GetMapping("api/refresh")
    public void refresh(){
        covid19Service.scrapOfficielWebSiteOfMorocco();
    }
}
