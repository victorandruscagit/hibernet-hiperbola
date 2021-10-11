package ru.javabegin.hibernate;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import ru.javabegin.hibernate.entity.User;

@Log4j2
public class Main {

    public static void main(String[] args) {
        log.info("Hibranta SQL started");
        Session session = HibernateUtil.getSessionFactory().openSession();
        //User user = session.get(User.class, 10025L);
        User user = session.get(User.class, 20040000L);
       /* log.info("is " + user.getUsername());
*/
        session.close();
        HibernateUtil.close();


    }

}
