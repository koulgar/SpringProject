package HibernateDemo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();
            //get the instructor by primary key/id
            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class,theId);
            System.out.println("Found Instructor: " + tempInstructor);
            //delete the instructors
            if(tempInstructor!=null){
                System.out.println("Deleting instructor: "+tempInstructor);
                session.delete(tempInstructor);
                //this will also delete associated "details" object.
                //because of CascadeType.ALL
            }
            //commit transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
