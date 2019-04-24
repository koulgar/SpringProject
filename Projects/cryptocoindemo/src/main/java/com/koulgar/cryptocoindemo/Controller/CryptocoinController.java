package com.koulgar.cryptocoindemo.Controller;

import com.koulgar.cryptocoindemo.Service.CryptocoinService;
import com.koulgar.cryptocoindemo.Entity.Cryptocoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coins")
public class CryptocoinController {

    private CryptocoinService cryptocoinService;

    public CryptocoinController(CryptocoinService cryptocoinService) {
        this.cryptocoinService = cryptocoinService;
    }

    @GetMapping("/list")
    public Iterable<Cryptocoin> listCoins(){
        return cryptocoinService.listCoins();
    }

}
