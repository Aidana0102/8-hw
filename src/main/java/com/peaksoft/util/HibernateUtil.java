package com.peaksoft.util;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    //private static final SessionFactory session = buildSessionFactory();


//    private static SessionFactory buildSessionFactory() {
//        try {
//            return (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        } catch (Throwable ex) {
//            System.out.println("Session not created : " + ex);
//
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

   // public static SessionFactory getSession(){
      //  return session;
    //}

  //    public static void shutDown(){
   //     getSession().close();
  //  }

    private static org.hibernate.SessionFactory buildSessionFactory() {
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "1234");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.peaksoft.entity.Student.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        System.out.println("Connected to hibernate");
        return cfg.buildSessionFactory(serviceRegistry);
    }
    private static final SessionFactory sessionFactory = (SessionFactory) buildSessionFactory();

    public static SessionFactory getSession() {
          return sessionFactory;
      }
   public static void shutDown() {
        getSession().close();
    }
}
