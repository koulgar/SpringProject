package HibernateDemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            //get the course
            int theId=10;
            Course course = session.get(Course.class,theId);
            //print the course
            System.out.println("Deleting Course: ...");
            System.out.println("Course: "+ course);
            //print the course reviews
            System.out.println("Course reviews: "+course.getReviews());
            //delete course
            session.delete(course);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
