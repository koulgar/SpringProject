package springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class RandomFortuneService implements FortuneService {

    private List<String> data = new ArrayList<String>();
    File file = new File("src/FortuneList");
    Scanner fileScanner = new Scanner(file);

    public RandomFortuneService() throws FileNotFoundException {
    }

    @PostConstruct
    public void getFortuneList(){
        for(int i=0;fileScanner.hasNextLine();i++){
            data.add(fileScanner.nextLine());
        }
    }

    @Override
    public String getFortune(){
        return data.get(randomNumber());
    }

    public int randomNumber(){
        int i = data.size();
        double randomNumber = Math.random()*i;
        return (int) randomNumber;
    }
}
