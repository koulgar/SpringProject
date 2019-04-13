package springdemo;

import org.springframework.stereotype.Component;

public class SampleCoach implements Coach {

    private FortuneService fortuneService;

    public SampleCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Sample Workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
