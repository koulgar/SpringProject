package springdemo;

import java.util.ArrayList;

public class RandomFortuneService implements FortuneService {
    ArrayList<String> array = new ArrayList<String>();
    @Override
    public String getFortuneService() {
        String fortune = (String) getFortune().get(randomNumber());
        return fortune;
    }

    public ArrayList getFortune() {
        array.add("You're gonna be happy");
        array.add("You're gonna be sad");
        array.add("You're gonna be wet");
        return array;
    }

    public int randomNumber(){
        double randomNumber = Math.random()*3;
        return (int) randomNumber;
    }
}
