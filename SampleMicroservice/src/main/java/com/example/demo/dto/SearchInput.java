package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchInput {
	private String id;
	private String gradeID;
	private String subjectID;
	private String subjectCategoryID;
	private String chapterID;
	private String questionTypeID;
	private String complexity;
	private String serachTerm;
}
