package springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(){
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it, " + fortuneService.getFortuneService();
    }

    //add an init method
    public void doMyStartUpStuff(){
        System.out.println("TrackCoach: init method initialized");
    }

    //add a destroy method
    public void doMyCleanUpStuff() {
        System.out.println("TrackCoach: exit method initialized");
    }
}
