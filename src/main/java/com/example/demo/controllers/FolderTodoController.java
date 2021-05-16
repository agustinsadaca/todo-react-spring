package com.example.demo.controllers;

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

import com.example.demo.model.FolderTodo;
import com.example.demo.service.FolderTodoService;

@RestController
@CrossOrigin(origins = "https://gifted-villani-0f9853.netlify.app")
@RequestMapping("/folder")
public class FolderTodoController {
@Autowired	
private FolderTodoService folderTodoService;
@GetMapping()
public ArrayList<FolderTodo> getAllFolders(){
	return folderTodoService.getAllFolders();
}
@PostMapping()
public FolderTodo saveFolder(@RequestBody FolderTodo folder) {
	return this.folderTodoService.saveFolder(folder);
}
@GetMapping(path= "{id}")
public Optional<FolderTodo> getTaskById(@PathVariable("id") Long id){
	return this.folderTodoService.getById(id);
}
@DeleteMapping(path = "/{id}")
public String deleteById(@PathVariable("id") Long id){
	boolean ok= this.folderTodoService.deleteFolder(id);
	if(ok) {
		return "Se elimino correctamente la tarea nro"+id;
	}else {
		return "No se pudo eliminar correctamente la tarea nro"+id;
	}
}
}


