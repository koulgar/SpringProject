package com.koulgar.springapidemo.service;

import com.koulgar.springapidemo.dao.LineDao;
import com.koulgar.springapidemo.entity.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LineServiceImp implements LineService {

    @Autowired
    private LineDao lineDao;

    @Override
    @Transactional
    public Line[] getQuotes() {
        return lineDao.getQuotes();
    }

    @Override
    @Transactional
    public Line getQuoteById(int quoteId) {
        return lineDao.getQuoteById(quoteId);
    }

}
