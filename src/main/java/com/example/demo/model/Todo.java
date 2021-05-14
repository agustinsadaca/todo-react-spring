package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean done;
    private Long id_folder;

   
	protected Todo() {

    }
    public Todo(long id, String task, boolean done,Long id_folder ) {
        this.id = id;
        this.task = task;   
        this.done = done;
        this.id_folder=id_folder;
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
    
    public void setId_folder(Long id_folder) {
		this.id_folder = id_folder;
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
    
    public Long getId_folder() {
		return id_folder;
	}
	

}