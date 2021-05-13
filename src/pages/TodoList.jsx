import React, { Fragment, useEffect, useState,Component } from 'react';
import { Link } from 'react-router-dom';
import TodoItem from './../component/TodoItem';


function TodoList() {

  const [todoItems,setTodoItems] = useState(null)
  const [folderName,setFolderName] = useState("")
  const queryString = window.location.pathname;
  const resul = queryString.replace('/tasks/',"")

  
  useEffect(() => {
  fetch(`http://localhost:8080/folder/${resul}`)
  .then(response => response.json())
  .then(todoItems =>{
    setFolderName(todoItems.folder_name);
  })  
  if (!todoItems) {  
    fetch(`http://localhost:8080/todo/query?id_folder=${resul}`)
    .then(response => response.json())
    .then(todoItems =>{
      if(todoItems.status!=400){
        setTodoItems(todoItems)
      }});
  }
  },[todoItems]);

  function addTask(){
    const enteredName = prompt('Please enter a task name')
    if(!enteredName){
    
    }else{
      var item ={
        "task":enteredName,
        "done":false,
        "folderId":parseInt(resul,10)
      }
      fetch(`http://localhost:8080/todo`,{
        method:'POST',
        dataType: 'jsonp',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body:JSON.stringify(item)
      })
      .then(response => response.json())
      .then( todoItems?item =>setTodoItems([...todoItems,item]):item =>setTodoItems([item])
        
        )
    }
  }

  function handleDeleteTodoItem(item) {
    const updateTodoItems = todoItems.filter((aItem) => aItem.id !== item.id);
    setTodoItems([...updateTodoItems]);
  }

  return (
    <div className="App">
      <h1>Tasks</h1>
      <h2>
        <Link to="/">Folder</Link>->{folderName}
      </h2>
      <button onClick={addTask}>Add task</button>
      {todoItems ? todoItems.map((todoItem) => {
        return( <TodoItem key={todoItem.id} data={todoItem} emitDeleteTodoItem={handleDeleteTodoItem} ></TodoItem>
        );  
      })
      :"No hay tareas"}
    </div>
  );
}
export default TodoList;