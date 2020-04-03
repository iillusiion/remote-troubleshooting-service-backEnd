package com.volunteer.web.hibernateutil;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	
	private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://google/volunteer?cloudSqlInstance=infra-rhino-272605:us-central1:volunteer&socketFactory=com.google.cloud.sql.mysql.SocketFactory");
            //prop.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/volunteer");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "root");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            concreteSessionFactory = new org.hibernate.cfg.Configuration()
                .addProperties(prop)
                .addPackage("com.volunteer")
               // .addAnnotatedClass(TblDistribution.class)
                .buildSessionFactory()
                ;
        }
        catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }

}