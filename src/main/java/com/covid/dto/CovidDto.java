package com.covid.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

public class CovidDto {

    @JsonProperty(value = "Country")
    private String country;

    @JsonProperty(value = "Confirmed")
    private int confirmed;

    @JsonProperty(value = "Deaths")
    private int deaths;

    @JsonProperty(value = "Recovered")
    private int recovered;

    @JsonProperty(value = "Active")
    private int active;

    @JsonProperty(value = "Negative")
    private int negative;

    @JsonProperty(value = "Date")
    private Date date;

    public CovidDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}



