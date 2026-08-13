package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.entity.Question;
import math.rest.exception.ResourceNotFoundException;
import math.rest.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(Long id) {
        return questionRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question", id));
    }

    @Override
    public List<Question> findAllByTopic(String topic) {
        return questionRepository
            .findAllByTopic(topic);
    }

    @Override
    public List<Question> findAllByDifficulty(String difficulty) {
        return questionRepository
            .findAllByDifficulty(difficulty);
    }

    @Override
    public List<Question> findAllByTopicAndDifficulty(String topic, String difficulty) {
        return questionRepository
            .findAllByTopicAndDifficulty(topic, difficulty);
    }

    @Override
    public Question create(Question form) {
        return questionRepository.save(form);
    }

    @Override
    public Question update(Question form) {
        return questionRepository.save(form);
    }

    @Override
    public void delete(Long id) {
        Question entity = questionRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question", id));
        questionRepository.delete(entity);
    }
}
