package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring conteiner
        TennisCoach theCoach = (TennisCoach) context.getBean("tennisCoach",Coach.class);

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        //call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        //call method to get daily fortune
        System.out.println(theCoach.getEmail());
        //call method to get daily fortune
        System.out.println(theCoach.getTeam());

        //close the context
        context.close();
    }
}
