package com.example.demo.model;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderTodoRepository extends CrudRepository<FolderTodo, Long>{

//	public abstract ArrayList<FolderTodo> findByfolder_name(String folder_name);
		
	
}
