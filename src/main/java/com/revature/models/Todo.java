package com.revature.models;

import java.util.Objects;

public class Todo {
	
	private String task;
	private boolean isComplete;
	
	public Todo(String task, boolean isComplete) {
		super();
		this.task = task;
		this.isComplete = isComplete;
	}

	public Todo() {
		super();
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isComplete, task);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return isComplete == other.isComplete && Objects.equals(task, other.task);
	}

	@Override
	public String toString() {
		return "Todo [task=" + task + ", isComplete=" + isComplete + "]";
	}
	
	

}
