package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPractiseDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanPractise-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach",Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        context.close();

    }
}
