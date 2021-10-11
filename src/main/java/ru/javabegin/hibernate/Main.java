package ru.javabegin.hibernate;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

@Log4j2
public class Main {

    public static void main(String[] args) {
        log.info("Hibranta SQL started");
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<Object[]> nativeQuery = session.createNativeQuery("select\n" +
                "count(u.id),\n" +
                "substring(u.email,position('@' in u.email) +1,length(u.email)) as domainEmail\n" +
                "\n" +
                "from todolist.user_data u\n" +
                "where u.email like '%@%'\n" +
                "group by domainEmail;");

        for (Object[] o : nativeQuery.getResultList()) {

            log.info( o[0]);
            log.info( o[1]);
            log.info("-----");


        }
        //log.info(resultList);

        session.close();
        HibernateUtil.close();


    }

}
