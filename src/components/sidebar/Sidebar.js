import React from "react";
import { slide as Menu } from "react-burger-menu";
import { Link } from "react-router-dom";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";

import "../../bootstrap.css";
import "./Sidebar.css";

function Sidebar(name) {
  return (
    <Menu>
      <List className="menu-items">
        <Link className="dropdown-item">
          <ListItem Button> Username </ListItem>
        </Link>
        <Link className="dropdown-item" to="/Homepage">
          <ListItem button> Dashboard </ListItem>
        </Link>
        <Link className="dropdown-item" to="/program-details">
          <ListItem Button> View Program Details </ListItem>
        </Link>
        <Link className="dropdown-item" to="/program-course-list">
          <ListItem Button> View Program Courses </ListItem>
        </Link>
        <Link className="dropdown-item" to="/course-details">
          <ListItem button> View Course Details </ListItem>
        </Link>
      </List>
    </Menu>
  );
}
export default Sidebar;
