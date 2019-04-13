package springdemo;

public class JockeyCoach implements Coach {
    private FortuneService heleFortuneService;

    public JockeyCoach(){
    }

    public void setFortuneService(FortuneService myFortuneService){
        System.out.println("setDailyFortune Method initialized.");
        this.heleFortuneService = myFortuneService;
    }

    public String getDailyFortune(){
        return heleFortuneService.getFortuneService();
    }

    public void startUpInit(){
        System.out.println("Start up initialized.");
    }

    public void closeUpInit(){
        System.out.println("Close up initialized.");
    }

    public String getDailyWorkout(){
        return "Ride for 3 hours.";
    }

}
