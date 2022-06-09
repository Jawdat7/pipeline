package com.revature.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Todo;

@Repository
public class TodoRepo {
	
	private List<Todo> todoList = new ArrayList<>();
	
	public TodoRepo() {
		super();
		todoList.add(new Todo("Make a cup of Java", false));
		todoList.add(new Todo("Feed my python", false));
		todoList.add(new Todo("Practice hitting a high C#", true));
	}
	
	public List<Todo> getAllTodos(){
		return todoList;
	}
	
	public Todo getTodoByIndex(int index) {
		return todoList.get(index);
	}
	
	public void addTodo(Todo todo) {
		todoList.add(todo);
	}
	
	public void updateTodo(Todo todo) {
		int index = -1;
		
		for(int i=0;i<todoList.size();++i) {
			if(todo.getTask().equals(todoList.get(i).getTask())) {
				index = i;
			}
		}
		if(index>=0) {
			todoList.get(index).setComplete(todo.isComplete());
		}
	}
	
	public void deleteTodo(Todo todo) {
		todoList.remove(todo);
	}

}
