package com.example.demo.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.RestServiceResponse;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("api/v1/question")
public class QuestionContreoller extends BaseController {
	
	private final QuestionService questionService;
	
	@Inject
	public QuestionContreoller(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<RestServiceResponse> getQuestionByID(@PathVariable String id) {
		final QuestionDTO questionDTO = questionService.getQuestionByID(id);
		return ResponseEntity.ok().body(getSucessResponse("Fetched successfully"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<RestServiceResponse> deleteQuestion(@PathVariable String id) {
		final boolean deleteResult=questionService.deleteQuestion(id);
		return ResponseEntity.ok().body(getSucessResponse("Deleted successfully"));
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<RestServiceResponse> saveQuestion(@RequestBody QuestionDTO questionDTO) {
		final QuestionDTO question =questionService.saveQuestion(questionDTO);
		return ResponseEntity.ok().body(getSucessResponse("Saved successfully"));
	}

	@PostMapping(value = "/search",consumes = "application/json")
	public ResponseEntity<RestServiceResponse> searchQuestions() {
		final List<QuestionDTO> questions=questionService.searchQuestions();
		return ResponseEntity.ok().body(getSucessResponse("search results returned"));
	}

}
