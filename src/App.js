import React, { Fragment, useEffect, useState } from 'react';
import './App.css';
import TodoItem from './component/TodoItem';

function App() {

  const [todoItems,setTodoItems] = useState(null)
  useEffect(() => {
  if (!todoItems) {  
    fetch('http://localhost:8080/todo')
    .then(response => response.json())
    .then(todoItems =>{
      console.log(todoItems);
      setTodoItems(todoItems)
    });
  }
  },[todoItems]);
  function addTask(){
    const enteredName = prompt('Please enter a task name')
    if(!enteredName){
    
    }else{
      var item ={
        "done":false,
        "task":enteredName
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
      .then(item =>setTodoItems([...todoItems,item]))
    }
  }
  function handleDeleteTodoItem(item) {
    const updateTodoItems = todoItems.filter((aItem) => aItem.id !== item.id);
    setTodoItems([...updateTodoItems]);
  }
 
  return (
    <div className="App">
      <h1>Todo App</h1>
      <button onClick={addTask}>Add task</button>
      {todoItems ? todoItems.map((todoItem) => {
        return( <TodoItem key={todoItem.id} data={todoItem} emitDeleteTodoItem={handleDeleteTodoItem} ></TodoItem>
        );  
      })
      :"Loading"}
    </div>
  );
}

export default App;
