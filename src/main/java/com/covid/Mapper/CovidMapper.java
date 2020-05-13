package com.covid.Mapper;


import com.covid.dto.CovidDto;
import com.covid.entity.Covid;


/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

public class CovidMapper {

    public static CovidDto mapperEntityToDTO(Covid covid) {
        if (covid == null) {
            return new CovidDto();
        }
        CovidDto covidWrapper = new CovidDto();
        covidWrapper.setCountry(covid.getCountry());
        covidWrapper.setDate(covid.getDate());
        covidWrapper.setConfirmed(covid.getConfirmed());
        covidWrapper.setActive(covid.getConfirmed()-covid.getDeaths()-covid.getRecovered());
        covidWrapper.setDeaths(covid.getDeaths());
        covidWrapper.setRecovered(covid.getRecovered());
        covidWrapper.setNegative(covid.getNegative());
        return covidWrapper;
    }
}
