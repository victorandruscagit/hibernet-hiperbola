package ru.javabegin.hibernate;

import org.hibernate.Session;
import ru.javabegin.hibernate.entity.User;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        User user = new User();
        user.setEmail("zcalin1@ff.ascom");
        user.setUsername("zcalingosia");
        user.setPassword("vera2");
        session.save(user);
        session.getTransaction().commit();
        System.out.println("user.getId() = " + user.getId());
        session.close();
        HibernateUtil.close();






    }

}
