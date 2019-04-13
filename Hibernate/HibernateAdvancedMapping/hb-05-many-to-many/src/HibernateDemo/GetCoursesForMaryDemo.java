package HibernateDemo;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCoursesForMaryDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            //get the student mary from database
            int studentId=1;
            Student student = session.get(Student.class,studentId);
            System.out.println("Loaded student: "+student);
            System.out.println("Courses: "+student.getCourses());

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
