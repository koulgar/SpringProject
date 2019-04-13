package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfigClass {

    @Bean
    public FortuneService sampleFortune(){
        return new SampleFortune();
    }

    @Bean
    public Coach sampleCoach(){
        return new SampleCoach(sampleFortune());
    }
}
