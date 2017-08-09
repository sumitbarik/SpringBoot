package com.demo.spring_boot_test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.spring_boot_test.topic.Topic;

@Service
public class TopicService {
  List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("1", "Java", "java details"),
      new Topic("2", "Srping MVC", "Srping MVC details"),
      new Topic("3", "Srping boot", "Srping boot details")));

  public List<Topic> getAllTopics() {
    return topics;
  }

  public Topic getTopic(String id) {
    return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
  }

  public void addTopic(Topic topic) {
    topics.add(topic);
  }

  public void updateTopic(Topic topic, String id) {
    for (Topic topicInst : topics) {
      if (topicInst.getId().equals(id)) {
        topicInst.setDesc(topic.getDesc());
        topicInst.setId(topic.getId());
        topicInst.setName(topic.getName());
      }
    }

  }

  public void deleteTopic(String id) {
    topics.removeIf(topic -> topic.getId().equals(id));
  }
}
