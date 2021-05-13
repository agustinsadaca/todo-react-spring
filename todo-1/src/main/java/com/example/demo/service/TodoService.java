package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoRepository;

@Service
public class TodoService {
	@Autowired
	TodoRepository todoRepository;
	public ArrayList<Todo> getAllTasks(){
		return (ArrayList<Todo>) todoRepository.findAll();
	}
	public Todo saveTask(Todo todo) {
		return todoRepository.save(todo);
	}
	public Optional<Todo> getById(Long id){
		return todoRepository.findById(id);
	}
	public ArrayList<Todo> getByFolder(Long id_folder){
		return todoRepository.findByFolderId(id_folder);
	}
	public boolean deleteTask(Long id) {
		try {
			todoRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}	
	}
	public void updateTodoItem(Long id, Todo todoItem) {
		
	}
	
}
