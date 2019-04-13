package HibernateDemo;


import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            int studentId=1;
            //get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve the student based on id
            System.out.println("Getting student with id; "+studentId);
            Student student = session.get(Student.class,studentId);
            System.out.println("Get complete: "+student);
            student.setFirstName("Scooby");
            //commit transaction
            session.getTransaction().commit();

            session=factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='test@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done..");

        }finally {
            factory.close();
        }

    }
}
