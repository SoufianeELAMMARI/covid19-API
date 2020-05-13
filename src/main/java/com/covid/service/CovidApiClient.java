package com.covid.service;

import com.covid.dto.CountryDto;
import com.covid.dto.CovidDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

@FeignClient(value = "covid19api", url = "https://api.covid19api.com/")
public interface CovidApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "total/country/{country}", produces = "application/json")
    List<CovidDto> getCovidStatisticsByCountry(@PathVariable("country") String country);

    @RequestMapping(method = RequestMethod.GET, value = "countries", produces = "application/json")
    List<CountryDto> getAllCountries();
}

