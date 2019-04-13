package springdemo;

import org.springframework.stereotype.Component;

public class SampleFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "Sample Fortune";
    }
}
