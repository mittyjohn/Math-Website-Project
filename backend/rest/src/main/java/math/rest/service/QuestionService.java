package math.rest.service;

import math.rest.dto.QuestionDTO;
import math.rest.entity.Question;
import math.rest.entity.QuestionDifficulty;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Question findById(Long id);

    List<Question> findAllByTopic(String topic);

    List<Question> findAllByDifficulty(QuestionDifficulty difficulty);

    List<Question> findAllByTopicAndDifficulty(String topic, QuestionDifficulty difficulty);

    Question create(QuestionDTO form);

    Question update(QuestionDTO form);

    void delete(Long id);

}