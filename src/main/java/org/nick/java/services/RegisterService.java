package org.nick.java.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.nick.java.dao.User;
import org.nick.java.util.HibernateUtil;

public class RegisterService {

    private UserService userService = new UserService();

    public String registerUser(String username, String password){
            Session session = HibernateUtil.openSession();
            Transaction tx = null;
            try{
                tx = session.getTransaction();
                tx.begin();
                User user = new User(username, password);
                if(userService.userExists(user) == true){
                    return "Username already exists";
                }
                session.save(user);
                tx.commit();
            }
            catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                if(e instanceof ConstraintViolationException){
                    return "username already exists";
                }
                return "error";
            }
            finally {
                session.close();
            }
            return "success";

        }
}
