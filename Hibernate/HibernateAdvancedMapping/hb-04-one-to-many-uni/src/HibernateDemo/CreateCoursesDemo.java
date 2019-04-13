package HibernateDemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
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
            //create some courses
            Course tempCourse1 = new Course("Air Guitar");
            Course tempCourse2 = new Course("Pinball ");

            //add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            //save courses
            session.save(tempCourse1);
            session.save(tempCourse2);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
