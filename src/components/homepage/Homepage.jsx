import React, { Component } from "react";
import Card from "../dashboard/card";

import "../../bootstrap.css";
import "../../index.css";

class Homepage extends Component {
  render(userType) {
    userType = "PMCC";

    if (userType === "PM") {
      return (
        <div className="center">
          <Card 
            cardHeader="Assigned Programs"
            cardTitle="Bachelor of Computer Science(BP094GEN8)"
            cardDesc="Undergraduate Computer Science Program"
            cardBtn="Program Details"
          />
        </div>
      );
    } else if (userType === "CC") {
      return (
        <div className="center">
          <Card 
            cardHeader="Assigned Courses"
            cardTitle="Programming 1 (C1111)"
            cardDesc="Lorem ipsum dolor sit amet, consectetur adipiscing elit"
            cardBtn="Course Details"
          />
        </div>
      );
    } else if (userType === "PMCC") {
      return (
        <div className="center">
          <Card 
            cardHeader="Assigned Programs"
            cardTitle="Bachelor of Computer Science(BP094GEN8)"
            cardDesc="Undergraduate Computer Science Program"
            url ="/program-details"
            cardBtn="Program Details"
          />

          <Card 
            cardHeader="Assigned Courses"
            cardTitle="Programming 1 (C1111)"
            cardDesc="Lorem ipsum dolor sit amet, consectetur adipiscing elit"
            url="/course-details"
            cardBtn="Course Details"
          />
        </div>
      );
    }
  }
}

export default Homepage;
