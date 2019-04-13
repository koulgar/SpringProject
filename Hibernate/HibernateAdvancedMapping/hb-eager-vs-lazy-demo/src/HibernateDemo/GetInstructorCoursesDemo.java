package HibernateDemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            //get the instructor from db
            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class,theId);
            System.out.println("The Instructor: "+tempInstructor);
            //get course for the instructor
            System.out.println("Courses: "+ tempInstructor.getCourses());

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
