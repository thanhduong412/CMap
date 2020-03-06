import React from "react";
import ReactDOM from "react-dom";
import TopicList from "../TopicList.jsx";

it("renders without crashing", ()=>{
    const div = document.createElement("div");
    ReactDOM.render(<TopicList/>, div);
});
