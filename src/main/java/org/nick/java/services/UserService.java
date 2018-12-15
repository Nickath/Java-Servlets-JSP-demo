package org.nick.java.services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nick.java.dao.User;
import org.nick.java.util.HibernateUtil;

import java.util.List;

public class UserService {

    public boolean userExists(User user){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        boolean exists = false;
        try{
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User");
            List<User> users = query.list();
            exists = users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()));//using stream to check whether already existing user with username
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return exists;
    }


}
