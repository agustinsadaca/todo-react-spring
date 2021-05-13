
import React, { useEffect, useState } from 'react';
import './FolderTodoItem.css';
import {Link} from "react-router-dom";


const FolderTodoItem = (props) =>{
  const {emitDeleteTodoFolder} = props
  const [todoFolder,setTodoFolder]=useState(props.data)

  function updateFolder(e){
    setTodoFolder({...todoFolder,folder_name:e.target.value});
    console.log(e.target.value)
  }
  function deleteFolder(){
    fetch(`http://localhost:8080/folder/${todoFolder.id}`,{
      method:'DELETE',
      dataType: 'jsonp',
      headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
      },
    })
    .then(response => emitDeleteTodoFolder(todoFolder))
    
  }
  useEffect(() =>{
    fetch(`http://localhost:8080/folder`,{
      method:'POST',
      dataType: 'jsonp',
      headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
      },
      body:JSON.stringify(todoFolder)
    })
    .then(response => response.json())
    .then(todoFolders =>{})
  })

  return (  
    <>
      <div className="folder"> 
        <input type="text" value={todoFolder.folder_name} onChange={updateFolder}/>
        <Link to={"/tasks/"+todoFolder.id}>View Item</Link>
        <span style={{cursor:'pointer'}} onClick={deleteFolder}>🗑️</span>
      </div>
    </>
  );
}

 
export default FolderTodoItem;