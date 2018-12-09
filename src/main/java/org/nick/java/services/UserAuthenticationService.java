package org.nick.java.services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nick.java.dao.User;
import org.nick.java.util.HibernateUtil;

public class UserAuthenticationService {


    public static boolean isUserValid(String username, String password){
        long userId = getUserIdByUsername(username);
        User user = getUserByUserId(userId);
        if(user!=null && user.getId() == userId && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }


    private static long getUserIdByUsername(String username) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where username='"+username+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if(user!=null){
            return user.getId();
        }
        return -1;
    }


    public static User getUserByUsername(String username) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where username='"+username+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
       return user;
    }



    public static User getUserByUserId(long userId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where id='"+userId+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }


}
