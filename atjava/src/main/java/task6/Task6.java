package task6;
//General:
//Install MySQL server (or any SQL like db)
//Make at least two tables (entities from the previous task)
//Make models for those entities (from Task_5)
//Setup Hibernate for those entities
//Check basic CRUD (create, read, update, and delete the BD records using Hibernate)
//Generate a few rows into all tables
import org.hibernate.Session;

import java.util.UUID;

public class Task6 {
    public static void main(String[] args) {
        Session session = null;
        //create
        Address newAddress = create();

        //read
        session = HibernateUtil.getSessionFactory().openSession();
        Address addressread = session.get(Address.class, newAddress.getId());
        System.out.println(addressread);
        session.close();

        //update
        session = HibernateUtil.getSessionFactory().openSession();
        addressread.setCity("updatedCity");
        session.beginTransaction();
        session.update(addressread);
        session.getTransaction().commit();
        session.close();

        //create
        Address addressToDelete = create();

        //delete
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(addressToDelete);
        session.getTransaction().commit();
        session.close();

    }
    private static Address create (){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Address address = new Address(UUID.randomUUID().toString().substring(0,10),"kittenCity", "meowState");
        Integer id = (Integer) session.save(address);
        session.getTransaction().commit();
        session.close();
        return address;
    }
}
