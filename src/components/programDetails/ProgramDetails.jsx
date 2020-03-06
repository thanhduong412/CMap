import React, { Component } from "react";
import { Datatable } from "@o2xp/react-datatable";

import ProgramService from "../API/program/ProgramService.js";

class ProgramDetails extends Component {
  constructor(props) {
    super(props);
    this.state = {
      option: {}
    };
    this.refreshList = this.refreshList.bind(this);
    this.reRoute = this.reRoute.bind(this);
  }

  componentDidMount() {
    this.refreshList();
  }

  refreshList() {
    ProgramService.getProgramList().then(response => {
      let resData = response.data;

      let expandData = [
        {
          code: resData[0].programID.code,
          year: resData[0].programID.year,
          name: resData[0].name,
          target: resData[0].target
        }
      ];

      this.setState({
        option: this.getOption(expandData)
      });
    });
  }

  reRoute() {
    this.props.history.push("/program-course-list");
  }

  getOption(data) {
    let options = {
      keyColumn: "code",
      data: {
        columns: [
          {
            id: "code",
            label: "Program Code"
          },
          {
            id: "name",
            label: "Program Name"
          },
          {
            id: "target",
            label: "Program Target"
          }
        ],
        rows: data
      }
    };

    return options;
  }

  render() {
    return (
      <div className="container centre">
        <div className="container centre bm-4">
          <h1>Program Details</h1>
        </div>
        <Datatable options={this.state.option} />
        <button onClick={this.reRoute} className="btn btn-outline-primary">
          View Courses Allocated to this Program
        </button>
      </div>
    );
  }
}

export default ProgramDetails;
