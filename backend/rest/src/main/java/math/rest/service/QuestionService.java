package math.rest.service;

import math.rest.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Question findById(Long id);

    List<Question> findAllByTopic(String topic);

    List<Question> findAllByDifficulty(String difficulty);

    List<Question> findAllByTopicAndDifficulty(String topic, String difficulty);

    Question create(Question form);

    Question update(Question form);

    void delete(Long id);

}