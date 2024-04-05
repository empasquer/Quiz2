package com.example.quiz2.repository;

import com.example.quiz2.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Question> getQuestionsFromQuizId(Long id) {
        String query = "SELECT * FROM question WHERE quiz_id = ?;";
        RowMapper<Question> rowMapper = new BeanPropertyRowMapper<>(Question.class);
        return jdbcTemplate.query(query, rowMapper, id);
    }
}
