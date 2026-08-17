package math.rest.controller;

import lombok.AllArgsConstructor;
import math.rest.dto.QuestionDTO;
import math.rest.entity.Question;
import math.rest.entity.QuestionDifficulty;
import math.rest.service.QuestionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/diff")
    public QuestionDifficulty[] findByDifficulty() {
        return QuestionDifficulty.values();
    }

    @GetMapping("/all")
    public List<Question> allQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/id/{id}")
    public Question findById(
        @PathVariable Long id
    ) {
        return questionService.findById(id);
    }

    @GetMapping("/topic/{topic}")
    public List<Question> findByTopic(
        @PathVariable String topic
    ) {
        return questionService.findAllByTopic(topic);
    }

    @GetMapping("/diff/{difficulty}")
    public List<Question> findByDifficulty(
        @PathVariable String difficulty
    ) {
        QuestionDifficulty qd = QuestionDifficulty.valueOf(difficulty.toUpperCase());
        return questionService.findAllByDifficulty(qd);
    }

    @GetMapping("/topic/{topic}/diff/{difficulty}")
    public List<Question> findByTopicAndDifficulty(
        @PathVariable String topic,
        @PathVariable String difficulty
    ) {
        QuestionDifficulty qd = QuestionDifficulty.valueOf(difficulty.toUpperCase());
        return questionService.findAllByTopicAndDifficulty(topic, qd);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Question create(QuestionDTO question) {
        return questionService.create(question);
    }

    @PutMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Question update(QuestionDTO question) {
        return questionService.update(question);
    }

    @DeleteMapping("/del/{id}")
    void delete(@PathVariable Long id) {
        questionService.delete(id);
    }
}