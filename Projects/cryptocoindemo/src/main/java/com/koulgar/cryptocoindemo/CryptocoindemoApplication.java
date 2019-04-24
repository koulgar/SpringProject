package com.koulgar.cryptocoindemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koulgar.cryptocoindemo.Service.CryptocoinService;
import com.koulgar.cryptocoindemo.Entity.Cryptocoin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CryptocoindemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptocoindemoApplication.class, args);
    }

//    @Bean
//    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }

    @Bean
    CommandLineRunner runner(CryptocoinService cryptocoinService){
        return args -> {
            //read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Cryptocoin>> typeReference = new TypeReference<List<Cryptocoin>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/JSON/coins.json/");
            try {
                List<Cryptocoin> cryptocoins = mapper.readValue(inputStream,typeReference);
                cryptocoinService.saveAll(cryptocoins);
                System.out.println(cryptocoins);
                System.out.println("Coins Saved!");
            } catch (IOException exc){
                System.out.println("Unable to save coins: "+exc.getMessage());
            }
        };
    }

    //https://api.coinmarketcap.com/v1/ticker/

}
