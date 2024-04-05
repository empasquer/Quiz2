package com.example.quiz2.controller;

import com.example.quiz2.model.Question;
import com.example.quiz2.model.Quiz;
import com.example.quiz2.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    QuizService quizService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("quizList",quizService.getAllQuiz());
        return "home/index";
    };

    @GetMapping("/quiz/{id}")
    public String getQuizPage(@PathVariable("id") Long id, Model model) {
        Quiz quiz = quizService.getQuizById(id);

        if (quiz != null) {
            model.addAttribute("quiz", quiz);
            return "home/quiz"; // Return the name of the Thymeleaf template
        } else {
            // Handle case when quiz with the provided ID is not found
            return "home/quizNotFound"; // Return a custom error page
        }
    }
}
