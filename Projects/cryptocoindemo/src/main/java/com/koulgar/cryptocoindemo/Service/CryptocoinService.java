package com.koulgar.cryptocoindemo.Service;

import com.koulgar.cryptocoindemo.Entity.Cryptocoin;

import java.util.List;

public interface CryptocoinService {

    Iterable<Cryptocoin> listCoins();

    Cryptocoin save(Cryptocoin coin);

    Iterable<Cryptocoin> saveAll(List<Cryptocoin> coins);
}
