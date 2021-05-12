package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/todo")
public class TodoController {
@Autowired	
private TodoService todoService;
@GetMapping()
public ArrayList<Todo> getAllTasks(){
	return todoService.getAllTasks();
}
@PostMapping()
public Todo saveTodo(@RequestBody Todo todo) {
	return this.todoService.saveTask(todo);
}
@GetMapping(path= "{id}")
public Optional<Todo> getTaskById(@PathVariable("id") Long id){
	return this.todoService.getById(id);
}
@DeleteMapping(path = "/{id}")
public String deleteById(@PathVariable("id") Long id){
	boolean ok= this.todoService.deleteTask(id);
	if(ok) {
		return "Se elimino correctamente la tarea nro"+id;
	}else {
		return "No se pudo eliminar correctamente la tarea nro"+id;
	}
}
//@PutMapping("/todo/{id}")
//public ResponseEntity<?> updateTodoItem(@PathVariable Long id, @RequestBody Todo todoItem ){
//	this.todoService.updateTodoItem(id,todoItem);
//	return 
//}
}

//@GetMapping("/api/todoItems")
//public ResponseEntity<?> fetchAllTodoItems(){
//	 List<TodoItem> todoItems = todoService.fetchAllTodoItems();
//	return ResponseEntity.ok(todoItems);
//}

