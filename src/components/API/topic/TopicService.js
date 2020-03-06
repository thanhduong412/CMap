import axios from "axios";

class TopicService {
  getTopicList() {
    return axios.get("http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/topic-list");
  }

  getCourseTopicList(courseCode) {
    return axios.get("http://cmapbackend-env.dz3ak2mbhv.ap-southeast-2.elasticbeanstalk.com/course-topic-details", {
      params: {
        "courseCode": courseCode            
      }
    });
  }
}

export default new TopicService();
