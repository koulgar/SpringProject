package com.koulgar.cryptocoindemo.Dao.CryptocoinDao;

import com.koulgar.cryptocoindemo.Entity.Cryptocoin;
import org.springframework.data.repository.CrudRepository;

public interface CryptocoinDao extends CrudRepository<Cryptocoin,Integer> {

}
