package com.example.demo.service;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FolderTodo;
import com.example.demo.model.FolderTodoRepository;

@Service
public class FolderTodoService {
	@Autowired
	FolderTodoRepository folderTodoRepository;

	public ArrayList<FolderTodo> getAllFolders(){
		return (ArrayList<FolderTodo>) folderTodoRepository.findAll();
	}
	public FolderTodo saveFolder(FolderTodo folderTodo) {
		return folderTodoRepository.save(folderTodo);
	}
	public Optional<FolderTodo> getById(Long id){
		return folderTodoRepository.findById(id);
	}

	public boolean deleteFolder(Long id) {
		try {
			folderTodoRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}	
	}
	public void updateTodoFolder(Long id, FolderTodo folderTodoItem) {
		
	}
	
}
