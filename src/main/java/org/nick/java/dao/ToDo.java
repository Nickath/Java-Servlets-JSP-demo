package org.nick.java.dao;

import javax.persistence.*;

@Entity
@Table(name="todos")
public class ToDo {

    @Id
    @GeneratedValue
    private long id;

    private String description;

    //FK
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public ToDo(){

    }

    public ToDo(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ToDo(String description){
        this.description = description;
    }

    public ToDo(String description, long userId) {
        this.description = description;
        this.user = new User(userId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
