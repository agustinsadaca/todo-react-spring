package com.example.demo.modelo;
import com.example.demo.modelo.Todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{
//	private List<TodoItem> todoItems = new ArrayList<>();
//	public List<TodoItem>fetchAllTodoItems(){
//		return todoItems;
//	}
	public abstract ArrayList<Todo> findBytask(String task);
		
	
}
