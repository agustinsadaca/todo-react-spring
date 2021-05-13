import React, { Fragment, useEffect, useState,Component } from 'react';
import './App.css';
import TodoItem from './component/TodoItem';
import {BrowserRouter as Router,Route,Switch,Link,Redirect} from "react-router-dom";
import { render } from '@testing-library/react';
import MainPage from "./pages";
import TodoList from "./pages/TodoList";

class App extends Component{

  render(){
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={MainPage}/>
        <Route exact path="/tasks/" component={TodoList}/>
        <Route component={TodoList}/>
      </Switch>
    </Router>  
  );
  }
}

export default App;
