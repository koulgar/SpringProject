package springdemo;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;

    //add fields for emailAdress and team
    private String emailAdress;
    private String team;

    //create setter/getter methods
    public void setEmailAdress(String emailAdress) {
        System.out.println("CricketCoach: inside setter method - setEmailAdress");
        this.emailAdress = emailAdress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam");
        this.team = team;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getTeam() {
        return team;
    }

    //create a no-arg constructor
    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructer");
    }

    //our setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 mins";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortuneService();
    }


}
