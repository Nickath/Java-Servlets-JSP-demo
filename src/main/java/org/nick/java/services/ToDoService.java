package org.nick.java.services;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nick.java.dao.ToDo;
import org.nick.java.dao.User;
import org.nick.java.util.HibernateUtil;

import java.util.List;

public class ToDoService {



    public List<ToDo> retrieveToDos(String name){
        User user = UserAuthenticationService.getUserByUsername(name);
        List<ToDo> toDoList = getToDosById(user.getId());
        System.out.println(toDoList.size() + " todos");
        return toDoList;

    }


    public List<ToDo> getToDosById(long id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<ToDo> toDoList = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from ToDo where user_id='"+id+"'");
            toDoList = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return toDoList;
    }

    public void addTodo(String description, long userId){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            ToDo toDo = new ToDo(description,userId);
            session.save(toDo);
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
