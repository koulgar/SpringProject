package com.koulgar.springapidemo.controller;

import com.koulgar.springapidemo.entity.Line;
import com.koulgar.springapidemo.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinesController {

    @Autowired
    private LineService lineService;
    Line[] quotes = lineService.getQuotes();

    @GetMapping("/quotes")
    public Line[] getQuotes(){
        return quotes;
    }

    @GetMapping("/quotes/{quoteId}")
    public Line getQuoteById(@PathVariable int quoteId){
        Line quote = lineService.getQuoteById(quoteId);
        return quote;
    }

}
