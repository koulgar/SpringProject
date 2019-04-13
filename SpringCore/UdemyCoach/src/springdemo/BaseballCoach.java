package springdemo;

public class BaseballCoach implements Coach {

    //define a private field for the dependency
    private FortuneService fortuneService;


    //define a constructor for the dependency
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 min. on batting practice";
    }

    @Override
    public String getDailyFortune() {
        //use my fortuneService to get a fortune
        return fortuneService.getFortuneService();
    }
}
