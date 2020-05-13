package com.covid.repository;

import com.covid.entity.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */


@Repository
public interface CovidRepository extends JpaRepository<Covid, Long> {
    Covid findTopByCountryOrderByDateDesc(String country);

    @Query(value = "select * from covid where id in (select max(id) from covid group by DATE(created_on)) order BY created_on Desc limit 2", nativeQuery = true)
    List<Covid> findLastTwoStatistic();
}




