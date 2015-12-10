/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author alumno
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    public static void buildSessionFactory() {
        if (sessionFactory == null) {
              Configuration configuration = new Configuration();
              configuration.configure();
              configuration.setProperty("hibernate.current_session_context_class", "thread");
//              StandardServiceRegistry serviceRegistry = new StandardServiceRegistry().applySettings(configuration.getProperties()).buildServiceRegistry();
//              sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public static void closeSessionFactory() {
        Session session = ThreadLocalSessionContext.unbind(sessionFactory);
        if (session != null) {
            session.close();
        }
    }
}
