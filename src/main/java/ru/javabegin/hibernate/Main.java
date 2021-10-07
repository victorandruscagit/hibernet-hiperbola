package ru.javabegin.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.javabegin.hibernate.entity.User;

import java.util.List;

@Log4j2
public class Main {

    public static void main(String[] args) {
        log.info("Hibernate tutorial started");
        Session session = HibernateUtil.getSessionFactory().openSession();


        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Query<User> query = session.createQuery(criteriaQuery);
        List<User> resultList = query.getResultList();
        log.info(resultList);
        session.close();
        HibernateUtil.close();


    }

}
