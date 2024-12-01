package com.example.demo.repository;

import java.util.List;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.SearchInput;
import com.example.demo.dto.SearchResult;

public interface QuestionRepository {

	public QuestionDTO getQuestionByID(final String id);
	public boolean deleteQuestion(final String id);
	public boolean isQuestionExists(final String id);
	public QuestionDTO saveQuestion(final QuestionDTO question);
	long getNextSequence(final String sequenceKey);
	List<SearchResult> searchQuestions(SearchInput searchInput);

}
