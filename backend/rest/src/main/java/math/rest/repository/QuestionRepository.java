package math.rest.repository;

import math.rest.entity.Question;
import math.rest.entity.QuestionDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByTopic(String topic);

    List<Question> findAllByDifficulty(QuestionDifficulty difficulty);

    List<Question> findAllByTopicAndDifficulty(String topic, QuestionDifficulty difficulty);

}