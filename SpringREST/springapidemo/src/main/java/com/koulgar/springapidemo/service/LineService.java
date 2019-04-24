package com.koulgar.springapidemo.service;

import com.koulgar.springapidemo.entity.Line;

public interface LineService {

    Line[] getQuotes();

    Line getQuoteById(int quoteId);
}
