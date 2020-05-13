package com.covid.service;


import com.covid.Mapper.CovidMapper;
import com.covid.dto.CountryDto;
import com.covid.dto.CovidDto;
import com.covid.entity.Covid;
import com.covid.repository.CovidRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

@Service
public class Covid19Service {

    final private String MOROCCO = "morocco";

    @Value("${covid.maroc.website}")
    private String covidmaroc;


    @Autowired
    CovidRepository covidRepository;

    @Autowired
     CovidApiClient covidApiClient;


    /**
     * THIS SERVICE FOR GETTING ALL COUNTRIES
     *
     * @return List<CountryDto>
     */
    public List<CountryDto> getAllCountries() {
        return covidApiClient.getAllCountries();
    }


    /**
     * THIS SERVICE FOR HANDLING STATISTICS OF COVID 19 PER COUNTRY
     * WITH SPECIFIC HANDLING FOR MOROCCAIN COUNTRY USING SCRAPING
     *
     * @param country
     * @return CovidDto
     */
    public List<CovidDto> getCovidStatisticsPerCountry(String country) {
        switch (country) {
            case MOROCCO:
                List<CovidDto> covidDtoList = new ArrayList<>();
                covidRepository.findLastTwoStatistic().forEach(covid -> covidDtoList.add(CovidMapper.mapperEntityToDTO(covid)));
                Collections.reverse(covidDtoList);
                return covidDtoList;
            default:
                return covidApiClient.getCovidStatisticsByCountry(country);
        }
    }
    /**
     * THIS IS THE SCHEDULED JOB FOR SRAPPING OFFICIEL MOROCCAIN WEBSITE
     * OF COVID 19 STATISTICS HOURLY (10H,14H,16H,18H)
     */
    @Scheduled(cron = "0 0 10,14,16,17,18 * * * ")
    public void scrapOfficielWebSiteOfMorocco() {
        try {

            Document doc = Jsoup.connect(covidmaroc).get();
            Elements element = doc.select("p");
            String[] spans = element.get(2).text().split(" ");
            Covid covid = new Covid();
            covid.setCountry(MOROCCO);
            covid.setRecovered(Integer.valueOf(spans[0]));
            covid.setDeaths(Integer.valueOf(spans[1]));
            covid.setConfirmed(Integer.valueOf(element.get(4).text()));
            covid.setNegative(Integer.valueOf(element.get(5).text()));
            covid.setDate(new Date());
            covidRepository.save(covid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}