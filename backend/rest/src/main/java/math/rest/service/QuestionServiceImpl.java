package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.dto.QuestionDTO;
import math.rest.entity.Question;
import math.rest.entity.QuestionDifficulty;
import math.rest.exception.ResourceNotFoundException;
import math.rest.mapper.QuestionMapper;
import math.rest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    @Autowired
    private final QuestionMapper mapper;

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
    public List<Question> findAllByDifficulty(QuestionDifficulty difficulty) {
        return questionRepository
            .findAllByDifficulty(difficulty);
    }

    @Override
    public List<Question> findAllByTopicAndDifficulty(String topic, QuestionDifficulty difficulty) {
        return questionRepository
            .findAllByTopicAndDifficulty(topic, difficulty);
    }

    @Override
    public Question create(QuestionDTO form) {
        Question q = mapper.toEntity(form);
        return questionRepository.save(q);
    }

    @Override
    public Question update(QuestionDTO form) {
        Question q = questionRepository
            .findById(form.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Question", form.getId()));
        mapper.updateEntityFromDto(form, q);
        return questionRepository.save(q);
    }

    @Override
    public void delete(Long id) {
        Question entity = questionRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question", id));
        questionRepository.delete(entity);
    }
}
