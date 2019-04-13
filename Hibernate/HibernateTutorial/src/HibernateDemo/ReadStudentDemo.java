package HibernateDemo;


import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            //create a student object
            System.out.println("Creating new student object");
            Student tempStudent = new Student("Daffy","Duck","duffy@gmail.com");
            //start a transaction
            System.out.println("Transaction begins.");
            session.beginTransaction();
            //save the student object
            System.out.println("Saving object.");
            session.save(tempStudent);
            //commit transaction
            session.getTransaction().commit();
            //find out the student's id: primary key
            System.out.println("Saved student. Generated id: "+tempStudent.getId());
            //get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve the student based on id
            System.out.println("Getting student with id; "+tempStudent.getId());
            Student student = session.get(Student.class,tempStudent.getId());
            System.out.println("Get complete: "+student);
            //commit transaction
            System.out.println("Done..");

        }finally {
            factory.close();
        }

    }
}
