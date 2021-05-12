
import React, { useEffect, useState } from 'react';

const TodoItem = (props) =>{
  const {emitDeleteTodoItem} = props
  const [todoItem,setTodoItem]=useState(props.data)

  function updateDone(){
    setTodoItem({...todoItem,done:!todoItem.done});
  }
  function updateTask(e){
    setTodoItem({...todoItem,task:e.target.value});
    console.log(e.target.value)
  }
  function deleteTask(){
    fetch(`http://localhost:8080/todo/${todoItem.id}`,{
      method:'DELETE',
      dataType: 'jsonp',
      headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
      },
    })
    .then(response => emitDeleteTodoItem(todoItem))
    
  }
  useEffect(() =>{
    fetch(`http://localhost:8080/todo`,{
      method:'POST',
      dataType: 'jsonp',
      headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
      },
      body:JSON.stringify(todoItem)
    })
    .then(response => response.json())
    .then(todoItems =>{})
  })

  return (  
    <>
      <div className="tasks">
      <input type="checkbox"  checked={todoItem.done} onChange={updateDone}></input>
      {
        todoItem.done ? (<input  type="text" style={{textDecoration:'line-through'}} value={todoItem.task} readOnly/>) : 
        (<input type="text" value={todoItem.task} onChange={updateTask}/>)
      }
      <span style={{cursor:'pointer'}} onClick={deleteTask}>🗑️</span>
      </div>
    </>
  );
}

 
export default TodoItem;