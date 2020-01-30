package tirol.htl.anichstrasse.Maven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory f = Persistence.createEntityManagerFactory("Maven");
        EntityManager manager = f.createEntityManager();
        
        //Create Person
        /*Person p =new Person();
        p.setAge(18);
        p.setFirstName("Julia");
        p.setLastName("Bichler");
        
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        */
        
        
        //Update Person
        /*manager.getTransaction().begin();
        p.setFirstName("test");
        p.setLastName("test123");
        manager.getTransaction().commit();*/
        //Person p = manager.find(Person.class,2l);
        //System.out.println(p);
       
        
        //Remove Person
        /*manager.getTransaction().begin();
        manager.remove(p);
        manager.getTransaction().commit();*/
        
        //Hobby
        /*Hobby h = new Hobby();
        manager.getTransaction().begin();
        manager.persist(h);
        manager.getTransaction().commit();*/
        
        Person p =new Person();
        p.setAge(18);
        p.setFirstName("Julia");
        p.setLastName("Bichler");
        
        Hobby h = new Hobby(0, "Schwimmen", 0);
        manager.getTransaction().begin();
        manager.persist(h);
        manager.getTransaction().commit();
        
        p.setHobby(h);
        
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        
    }
}
