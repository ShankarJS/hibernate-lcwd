package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started.." );
        
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(106);
        st.setName("Durgesh Tiwari");
        st.setCity("Lucknow"); 
        System.out.println(st);
        
      //creating student
        Student st1 = new Student();
        st1.setId(108);
        st1.setName("Ankit");
        st1.setCity("Delhi"); 
        
        
      //creating student
        Student st2 = new Student();
        st2.setId(103);
        st2.setName("Karan Singh");
        st2.setCity("Kanpur"); 
        
        
        //creating address
        Address address = new Address();
        address.setStreet("Street 1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setDate(new Date());
        address.setX(1234.434);
        
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/TOP-CEO-INFLUENCER.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);
        fis.close();
        
      //creating address
        Address address2 = new Address();
        address2.setStreet("Street 2");
        address2.setCity("Kanpur");
        address2.setOpen(true);
        address2.setDate(new Date());
        address2.setX(1234.433);
        
        
      //Reading Image
        FileInputStream fis2 = new FileInputStream("src/main/java/collection.png");
        byte[] data2 = new byte[fis2.available()];
        fis2.read(data2);
        address2.setImage(data2);
        fis2.close();
        
        
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(st1);
        session.save(st2);
        session.save(address);
        session.save(address2);
        tx.commit();
        session.close();
        System.out.println("done..c	");
    
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}
