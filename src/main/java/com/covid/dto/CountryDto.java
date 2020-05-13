package com.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

public class CountryDto {

    @JsonProperty(value = "Country")
    private String country;
    @JsonProperty(value = "Slug")
    private String slug;
    @JsonProperty(value = "ISO2")
    private String iso2;

    public CountryDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
}
