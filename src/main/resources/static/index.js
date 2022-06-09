const url = "http://localhost:8081/";
let getTodosBtn = document.getElementById("getTodoBtn");
let todoList = document.getElementById("todoList");
let completeList = document.getElementById("completeList");
let newTodoBtn = document.getElementById("addTodoBtn");
let updateTodoBtn = document.getElementById("updateTodoBtn");

getTodosBtn.onclick=getAllTodos
newTodoBtn.onclick=addTodo;
updateTodoBtn.onclick=completeTodo;


async function getAllTodos(){
  let result = await fetch(url+"todo");
  if(result.status===200){
    let data = await result.json();
    populateLists(data);
  }else{
    console.log("Could not fetch todos.")
  }
}

function populateLists(data){

  todoList.innerHTML="";
  completeList.innerHTML="";

  for(todo of data){
    if(todo.complete==false){
      let element = document.createElement("li");
      element.innerText=todo.task;
      element.className = "list-group-item list-group-item-warning";
      todoList.appendChild(element);
    }else{
      let element = document.createElement("li");
      element.innerText=todo.task;
      element.className = "list-group-item list-group-item-success";
      completeList.appendChild(element);
    }
  }
}

async function addTodo(){
  let task = document.getElementById("newTodo").value;
  let todo = {
    task:task,
    complete:false
  };

  let response = await fetch(url+"todo", {
    method:"POST", 
    body:JSON.stringify(todo),
    headers:{'Content-Type':'application/json'}});
  
  if(response.status===201){
    console.log("todo was added");
  }else{
    console.log("Something went wrong. Status code returned was "+response.status);
  }
}

async function completeTodo(){
  let num = document.getElementById("updateTodo").value;
  let todos = todoList.getElementsByTagName('li');
  let task = todos[num-1].innerText;
  let todo = {
    task:task,
    complete:true
  };


  let response = await fetch(url+"todo", {
    method:"PUT", 
    body:JSON.stringify(todo),
    headers:{'Content-Type':'application/json'}});
  
  if(response.status===200){
    console.log("todo was completed");
  }else{
    console.log("Something went wrong. Status code returned was "+response.status);
  }
}