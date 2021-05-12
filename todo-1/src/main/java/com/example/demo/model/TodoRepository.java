package com.example.demo.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{

	public abstract ArrayList<Todo> findBytask(String task);
		
	
}
