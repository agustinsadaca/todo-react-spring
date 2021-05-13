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
    private Long folderId;

   
	protected Todo() {

    }
    public Todo(long id, String task, boolean done,Long folderId ) {
        this.id = id;
        this.task = task;   
        this.done = done;
        this.folderId=folderId;
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
    
    public void setfolderId(Long folderId) {
		this.folderId = folderId;
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
    
    public Long getfolderId() {
		return folderId;
	}
	

}