package com.covid.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

@Entity
public class Covid implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="CREATED_ON")
    private Date date;

    @Column(name ="COUNTRY")
    private String country;

    @Column(name ="CONFIRMED")
    private int confirmed;

    @Column(name ="DEATH")
    private int deaths;

    @Column(name ="RECOVERED")
    private int recovered;

    @Column(name ="NEGATIVE")
    private int negative;

    public Covid() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }
}
