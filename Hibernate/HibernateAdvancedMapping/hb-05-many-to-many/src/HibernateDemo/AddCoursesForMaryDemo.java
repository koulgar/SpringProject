package HibernateDemo;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {
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
            int studentId=2;
            Student student = session.get(Student.class,studentId);
            System.out.println("Loaded student: "+student);
            System.out.println("Courses: "+student.getCourses());
            //create more courses
            Course course1 = new Course("Rubik's Cube");
            Course course2 = new Course("Atari 2600");

            //add student to courses
            course1.addStudent(student);
            course2.addStudent(student);

            //save the courses
            System.out.println("Saving the courses.. ");
            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
