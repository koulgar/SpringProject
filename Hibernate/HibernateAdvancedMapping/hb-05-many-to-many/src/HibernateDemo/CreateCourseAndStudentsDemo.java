package HibernateDemo;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {
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

            // create course
            Course tempCourse = new Course("Pinball");
            //save course
            System.out.println("Saving course: " + tempCourse);
            session.save(tempCourse);
            //create students
            Student student1 = new Student("John","Doe","john@gmail.com");
            Student student2 = new Student("Mary","Public","mary@gmail.com");
            //add students to the course
            tempCourse.addStudent(student1);
            tempCourse.addStudent(student2);
            //save the students
            session.save(student1);
            session.save(student2);
            System.out.println("Saved Students: "+tempCourse.getStudents());

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
