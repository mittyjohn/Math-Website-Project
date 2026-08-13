package math.rest.repository;

import math.rest.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByTopic(String topic);

    List<Question> findAllByDifficulty(String difficulty);

    List<Question> findAllByTopicAndDifficulty(String topic, String difficulty);

}