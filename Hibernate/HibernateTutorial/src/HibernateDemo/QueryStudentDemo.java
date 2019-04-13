package HibernateDemo;



import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            //query students
            List students = session.createQuery("FROM Student s WHERE s.lastName='Duck'").getResultList();
            //display the students
            displayStudents(students);

            students = session.createQuery("FROM Student s WHERE " +
                    "s.lastName='Duck' OR s.firstName='mary'").getResultList();
            displayStudents(students);

            students = session.createQuery("FROM Student s WHERE s.email LIKE '%@gmail.com'").getResultList();
            displayStudents(students);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for(Student tempStudent: students){
            System.out.println(tempStudent);
        }
    }
}
