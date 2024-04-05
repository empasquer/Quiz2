package com.example.quiz2.repository;

import com.example.quiz2.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Quiz> getAllQuiz() {
        String query = "SELECT * FROM quiz;";
        RowMapper<Quiz> rowMapper = new BeanPropertyRowMapper<>(Quiz.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public Quiz getQuizFromId(Long id) {
        String query = "SELECT * FROM quiz WHERE id = ?;";
        RowMapper<Quiz> rowMapper = new BeanPropertyRowMapper<>(Quiz.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }
}
