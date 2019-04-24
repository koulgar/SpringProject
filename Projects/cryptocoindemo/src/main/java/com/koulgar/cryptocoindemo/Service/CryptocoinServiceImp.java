package com.koulgar.cryptocoindemo.Service;

import com.koulgar.cryptocoindemo.Dao.CryptocoinDao.CryptocoinDao;
import com.koulgar.cryptocoindemo.Entity.Cryptocoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptocoinServiceImp implements CryptocoinService {

    private CryptocoinDao cryptocoinDao;

    public CryptocoinServiceImp(CryptocoinDao cryptocoinDao) {
        this.cryptocoinDao = cryptocoinDao;
    }

    @Override
    public Iterable<Cryptocoin> listCoins(){
        return cryptocoinDao.findAll();
    }

    @Override
    public Cryptocoin save(Cryptocoin coin) {
        return cryptocoinDao.save(coin);
    }

    @Override
    public Iterable<Cryptocoin> saveAll(List<Cryptocoin> coins) {
        return cryptocoinDao.saveAll(coins);
    }

}
