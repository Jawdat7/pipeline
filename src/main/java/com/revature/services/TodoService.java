package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Todo;
import com.revature.repos.TodoRepo;

@Service
public class TodoService {

	private TodoRepo todoRepo;

	@Autowired
	public TodoService(TodoRepo todoRepo) {
		super();
		this.todoRepo = todoRepo;
	}
	
	public List<Todo> getTodoList(){
		return todoRepo.getAllTodos();
	}
	
	public Todo getSingleTodo(int index) {
		return todoRepo.getTodoByIndex(index);
	}
	
	public void addTodoToList(Todo todo) {
		todoRepo.addTodo(todo);
	}
	
	public void updateTodo(Todo todo) {
		todoRepo.updateTodo(todo);
	}
	
	public void removeTodo(Todo todo) {
		todoRepo.deleteTodo(todo);
	}
}
