package HibernateDemo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            //start a transaction
            session.beginTransaction();
            //get the instructor detail object
            int theId = 5;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            //print the instructor detail
            System.out.println("InstructorDetail: " + tempInstructorDetail);
            //print the associated instructor
            System.out.println("Associated instructor: " + tempInstructorDetail.getInstructor());
            //delete the instructor detail.
            System.out.println("Deleting instructor detail: "+ tempInstructorDetail);

            //USED FOR BREAKING THE CONNECTION BETWEEN INSTRUCTOR AND INSTRUCTOR DETAILS.
            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructorDetail);

            //commit transaction
            session.getTransaction().commit();

        }catch (Exception exc){
            //handle connection leaking issue
            session.close();
        }finally {
            factory.close();
        }
    }
}
