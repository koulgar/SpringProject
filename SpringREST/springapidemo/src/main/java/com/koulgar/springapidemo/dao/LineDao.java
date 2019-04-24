package com.koulgar.springapidemo.dao;

import com.koulgar.springapidemo.entity.Line;

public interface LineDao {

    Line[] getQuotes();

    Line getQuoteById(int quoteId);
}
