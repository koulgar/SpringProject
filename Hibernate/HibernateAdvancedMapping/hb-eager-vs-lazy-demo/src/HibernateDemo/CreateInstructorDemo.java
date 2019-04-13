package HibernateDemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            //create the objects
            Instructor tempInstructor = new Instructor("Dogucan","Durmuslar","dogucan@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/koulgar","coding");

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();

            System.out.println("Saving instructor: "+tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
