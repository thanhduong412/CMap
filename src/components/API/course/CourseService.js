import axios from "axios";

class CourseService {
  getCourseList() {
    return axios.get(
      "http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/courses-not-in-program/BP094GEN8"
    );
  }

  addCourse(course) {
    console.log("create");
    return axios.post(
      "http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/add-program-course",
      course
    );
  }

  getCourseTopicLevel(courseCode, topicCode) {
    return axios.get(
      "http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/course-topic-level",
      {
        params: {
          courseCode: courseCode,
          topicCode: topicCode
        }
      }
    );
  }

  updateCourseTopicLevel(topicDetails) {
    return axios.put(
      "http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/update-course-topic",
      topicDetails
    );
  }

  removeCourseTopic(topicCode) {
    return axios.delete(
      "http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/delete-course-topic",
      {
        params: {
          topicCode: topicCode
        }
      }
    );
  }
}

export default new CourseService();
