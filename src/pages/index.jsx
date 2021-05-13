import React, { Fragment, useEffect, useState,Component } from 'react';
import FolderTodoItem from './../component/FolderTodoItem';

function MainPage() {

  const [todoFolders,settodoFolders] = useState(null)
  useEffect(() => {
  if (!todoFolders) {  
    fetch('http://localhost:8080/folder')
    .then(response => response.json())
    .then(todoFolders =>{
      settodoFolders(todoFolders)
    });
  }
  },[todoFolders]);
  function addFolder(){
    const enteredName = prompt('Please enter a task name')
    if(!enteredName){
    
    }else{
      var item ={
        "folder_name":enteredName
      }
      fetch(`http://localhost:8080/folder`,{
        method:'POST',
        dataType: 'jsonp',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body:JSON.stringify(item)
      })
      .then(response => response.json())
      .then(item =>settodoFolders([...todoFolders,item]))
    }
  }
  function handleDeleteTodoFolder(item) {
    const updatetodoFolders = todoFolders.filter((aItem) => aItem.id !== item.id);
    settodoFolders([...updatetodoFolders]);
  }
 
  return (
    <div className="App">
      <h1>Todo App</h1>
      <button onClick={addFolder}>Add Folder</button>
      {todoFolders ? todoFolders.map((todoFolder) => {
        return( <FolderTodoItem key={todoFolder.id} data={todoFolder} emitDeleteTodoFolder={handleDeleteTodoFolder} ></FolderTodoItem>
        );  
      })
      :"Loading"}
    </div>
  );
}
export default MainPage;