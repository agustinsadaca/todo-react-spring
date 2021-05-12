package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean done;

    protected Todo() {

    }
    public Todo(long id, String task, boolean done) {
        this.id = id;
        this.task = task;   
        this.done = done;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public void setTask(String task) {
        this.task = task;
    }

   
    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {
        return id;
    }

   

    public String getTask() {
        return task;
    }

    
    public boolean isDone() {
        return done;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Todo todo = (Todo) o;
//        return id == todo.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}