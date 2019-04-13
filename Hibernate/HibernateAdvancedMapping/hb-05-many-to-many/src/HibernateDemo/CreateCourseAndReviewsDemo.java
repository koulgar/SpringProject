package HibernateDemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
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

            // create course
            Course tempCourse = new Course("Pacman");
            //add some reviews
            tempCourse.addReview(new Review("Great course.. Loved it!"));
            tempCourse.addReview(new Review("Cool course! "));
            tempCourse.addReview(new Review("Job well done!"));
            //save the course... and leverage the cascade all
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
