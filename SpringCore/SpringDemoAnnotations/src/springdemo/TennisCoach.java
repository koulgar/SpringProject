package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{

    @Value("${foo.team}")
    private String team;

    @Value("${foo.email}")
    private String email;

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    /*
    @Autowired
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
*/
    //define my init method
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println(">>TennisCoach: do my startup stuff");
    }

    //define my destroy method
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println(">>TennisCoach: do my cleanup stuff");
    }

    public String getTeam() {
        return team;
    }

    public String getEmail() {
        return email;
    }

    //define default constructor
    public TennisCoach(){
        System.out.println(">>TennisCoach: inside default constructor.");
    }
/*
    //define setter method
    @Autowired
    public void setFortuneService(FortuneService fortuneService){
        System.out.println(">>TennisCoach: inside setFortuneService method.");
        this.fortuneService = fortuneService;
    }
*/

/*
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService){
        System.out.println(">>TennisCoach: inside doSomeCrazyStuff method.");
        this.fortuneService = fortuneService;
    }
*/

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
