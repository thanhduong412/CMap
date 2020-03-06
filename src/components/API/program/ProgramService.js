import axios from "axios";

class ProgramService {
  getProgramList() {
    return axios.get("http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/code/BP094GEN8/year/2018");
  }

  getProgramCourseList() {
    return axios.get("http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/allCourseinProgram/BP094GEN8");
  }
  
  removeCourse(programCode, courseCode, semester) {
    return axios.delete("http://localhost:8080/delete-program-course", {
      params: {
        "programCode": programCode,
        "courseCode": courseCode,
        "semester": semester          
      }
    });
  }

  updateCourse(course) {
    console.log("update");
    return axios.put("http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/update-program-course", course);
  }
}

export default new ProgramService();
