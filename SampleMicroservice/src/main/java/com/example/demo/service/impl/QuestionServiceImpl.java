package com.example.demo.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	private final QuestionRepository questionRepository;
	
	@Inject
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public QuestionDTO getQuestionByID(String id) {
		return questionRepository.getQuestionByID(id);
	}

	@Override
	public boolean deleteQuestion(String id) {
		return questionRepository.deleteQuestion(id);
	}

	@Override
	public QuestionDTO saveQuestion(QuestionDTO question) {
		return questionRepository.saveQuestion(question);
	} 

	@Override
	public List<QuestionDTO> searchQuestions() {
		return questionRepository.searchQuestions();
	}

}
