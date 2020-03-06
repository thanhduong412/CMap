import React, { Component } from "react";
import { Datatable } from "@o2xp/react-datatable";
import { Link } from "react-router-dom";

import "../../bootstrap.css";
import "../../index.css";
import ProgramService from "../API/program/ProgramService.js";

class ProgramCourseList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      option: {}
    };
    this.refreshList = this.refreshList.bind(this);
    this.getOption = this.getOption.bind(this);
    this.deleteCourse = this.deleteCourse.bind(this);
    this.deleteRequest = this.deleteRequest.bind(this);
    this.updateCourse = this.updateCourse.bind(this);
    this.updateRequest = this.updateRequest.bind(this);
  }

  componentDidMount() {
    this.refreshList();
  }

  refreshList() {
    ProgramService.getProgramCourseList().then(response => {
      let resData = response.data;
      this.setState({
        option: this.getOption(resData)
      });
    });
  }

  deleteCourse(rowData) {
    let selectedLength = rowData.length;
    let data = rowData;

    if (selectedLength > 1) {
      var i;
      for (i = 0; i < selectedLength; i++) {
        this.deleteRequest(
          data[i].programCode,
          data[i].courseCode,
          data[i].semester
        );
      }
      this.refreshList();
    } else {
      console.log(data);
      console.log(data[0].courseCode);
      console.log(data[0].semester);
      console.log(data[0].programCode);
      this.deleteRequest(
        data[0].programCode,
        data[0].courseCode,
        data[0].semester
      );
      this.refreshList();
    }
  }

  deleteRequest(programCode, courseCode, semester) {
    ProgramService.removeCourse(programCode, courseCode, semester);
    window.location.reload();
  }

  updateCourse(rowData) {
    let selectedLength = rowData.length;
    let data = rowData;

    if (selectedLength > 1) {
      var i;
      for (i = 0; i < selectedLength; i++) {
        this.updateRequest(data[i]);
      }
    } else {
      console.log(data);
      this.updateRequest(data[0]);
    }

    this.props.history.push("/program-course-list");
    window.location.reload();
  }

  updateRequest(data) {
    ProgramService.updateCourse(data).then(response => {
      console.log(response);
      console.log(response.data);
    });
    window.location.reload();
  }

  getOption(data) {
    let options = {
      keyColumn: "courseCode",
      data: {
        columns: [
          {
            id: "courseCode",
            label: "Course Code",
            colSize: "50px"
          },
          {
            id: "title",
            label: "Course Name",
            colSize: "150px"
          },
          {
            id: "semester",
            label: "Semester",
            editable: true,
            inputType: "select",
            values: [0, 1, 2, 3, 4, 5, 6],
            colSize: "150px"
          }
        ],
        rows: data
      },
      features: {
        canEdit: true,
        canSelectRow: true,
        canSearch: true,
        selectionIcons: [
          {
            title: "Update Course(/s)",
            icon: (
              <button className="btn btn-outline-primary">
                Update Course(/s)
              </button>
            ),
            onClick: rows => this.updateCourse(rows)
          },
          {
            title: "Delete Course(/s)",
            icon: (
              <button className="btn btn-outline-danger">
                Delete Course(/s)
              </button>
            ),
            onClick: rows => this.deleteCourse(rows)
          }
        ]
      },
      dimensions: {
        row: {
          height: "120px"
        },
        datatable: {
          height: "1200px"
        }
      }
    };

    return options;
  }

  render() {
    return (
      <div className="container">
        <div className="container centre bm-4">
          <h1>Program Course List</h1>
        </div>
        <Datatable options={this.state.option} />
        <div className="container centre bm-4">
          <Link to="/course-list">
            <button className="btn btn-outline-primary">Add Course</button>
          </Link>
        </div>
      </div>
    );
  }
}

export default ProgramCourseList;
