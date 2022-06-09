package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Todo;
import com.revature.services.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	
	private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}


	@GetMapping
	@ResponseBody
	public List<Todo> getAllTodos(){
		return todoService.getTodoList();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
		todoService.addTodoToList(todo);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo){
		todoService.updateTodo(todo);
		return ResponseEntity.status(200).build();
	}

}
