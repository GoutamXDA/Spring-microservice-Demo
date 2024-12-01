package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.QuestionDTO;

public interface QuestionService {

	public QuestionDTO getQuestionByID(final String id);
	public boolean deleteQuestion(final String id);
	public QuestionDTO saveQuestion(final QuestionDTO question);
	public List<QuestionDTO> searchQuestions();
}
