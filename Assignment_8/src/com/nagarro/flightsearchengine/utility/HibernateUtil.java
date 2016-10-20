package com.nagarro.flightsearchengine.utility;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
        public static SessionFactory sessionFactory;
        public static ServiceRegistry serviceRegistry;
        
        static{
        	try{
        		Configuration configuration =new Configuration().configure();
        		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	 }catch(HibernateException e){
        	System.out.println("Problem in creating session Factory"+ e.getMessage().toString());	 
        	}
        }

        public static SessionFactory getSessionFactory() {
    		return sessionFactory;
    	}		
}