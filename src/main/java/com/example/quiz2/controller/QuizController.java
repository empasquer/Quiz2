package com.example.quiz2.controller;

import com.example.quiz2.model.Question;
import com.example.quiz2.model.Quiz;
import com.example.quiz2.service.QuizService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"score", "answers"})
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/submit-quiz/{id}")
    public String submitQuiz(@PathVariable Long id, @RequestParam("quizId") Long quizId,
                             @RequestParam Map<String, String> params, Model model) {
        // Retrieve the quiz from the database
        Quiz quiz = quizService.getQuizById(quizId);

        // Get the list of questions from the quiz
        List<Question> questions = quiz.getQuestions();

        List<String> answers = new ArrayList<>();

        // Initialize a variable to store the score
        int score = 0;

        // Iterate through each question
        for (Question question : questions) {
            // Retrieve the correct answer for the current question
            String correctAnswer = question.getCorrectAnswer();

            // Retrieve the submitted answer for the current question
            String submittedAnswer = params.get("answer_" + (question.getId() -1));

            answers.add(submittedAnswer);

            // Compare the submitted answer with the correct answer
            if (submittedAnswer != null && submittedAnswer.equals(correctAnswer)) {
                // Increment the score if the answer is correct
                score++;
            }
        }

        // Add the score and answers to the model
        model.addAttribute("score", score);
        model.addAttribute("answers", answers);

        // Redirect to a page to display the score or provide feedback to the user
        return "redirect:/quiz-score/" + id;
    }

    @GetMapping("/quiz-score/{id}")
    public String getQuizScore(Model model, @PathVariable Long id) {
        // Retrieve the quiz from the database
        Quiz quiz = quizService.getQuizById(id);

        // Retrieve the score and answers from the model attributes
        int score = (int) model.getAttribute("score");
        List<String> answers = (List<String>) model.getAttribute("answers");

        // Add the quiz, score, and answers to the model
        model.addAttribute("quiz", quiz);
        model.addAttribute("score", score);
        model.addAttribute("answers", answers);

        // Return the name of the Thymeleaf template for displaying the quiz score
        return "home/quiz-score";
    }
}
