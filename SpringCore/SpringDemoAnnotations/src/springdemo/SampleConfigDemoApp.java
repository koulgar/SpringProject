package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleConfigDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SampleConfigClass.class);

        Coach theCoach = context.getBean("sampleCoach",Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}
