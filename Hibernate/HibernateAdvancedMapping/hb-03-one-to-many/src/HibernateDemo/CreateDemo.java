package HibernateDemo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            //create the objects
            Instructor tempInstructor = new Instructor("Dogucan","Durmuslar","dogucan@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/koulgar","coding");

            //associate the objects together
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            //start a transaction
            session.beginTransaction();
            //save the instructor
            //this will also save details object because of CascadeType.ALL
            System.out.println("Saving instructor: "+tempInstructor);
            session.save(tempInstructor);
            //commit transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
