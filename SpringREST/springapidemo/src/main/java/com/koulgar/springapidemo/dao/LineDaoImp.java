package com.koulgar.springapidemo.dao;

import com.koulgar.springapidemo.entity.Line;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Repository
public class LineDaoImp implements LineDao {

    private Line[] lines;

    @PostConstruct
    public void LoadQuotes(){
        RestTemplate restTemplate = new RestTemplate();
        this.lines = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/",Line[].class);
    }

    @Override
    public Line[] getQuotes() {
        return lines;
    }

    @Override
    public Line getQuoteById(int quoteId) {
        return lines[quoteId];
    }

}
