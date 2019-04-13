package HibernateDemo;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeletePacmanCourseDemo {
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

            //get the pacman course from database
            int courseId=10;
            Course course = session.get(Course.class,courseId);

            //delete course ID from database
            System.out.println("Deleting course: "+course);

            session.delete(course);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
