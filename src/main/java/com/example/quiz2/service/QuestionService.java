package com.example.quiz2.service;

import com.example.quiz2.model.Question;
import com.example.quiz2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getQuizQuestionsFromQuizId(Long id) {
        return questionRepository.getQuestionsFromQuizId(id);
    }
}
