package com.example.quiz2.service;

import com.example.quiz2.model.Question;
import com.example.quiz2.model.Quiz;
import com.example.quiz2.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired QuestionService questionService;


    public List<Quiz> getAllQuiz() {
        return quizRepository.getAllQuiz();
    }

    public Quiz getQuizById(Long id) {
        Quiz quiz = quizRepository.getQuizFromId(id);

        if (quiz != null) {
            List<Question> quizQuestions = questionService.getQuizQuestionsFromQuizId(id);
            quiz.setQuestions(quizQuestions);
        } else {
            System.out.println("quiz is null and therefore id is null");
        }

        return quiz;
    }

}
