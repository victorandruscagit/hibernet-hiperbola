package ru.javabegin.hibernate;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
        HibernateUtil.close();
    }
}
