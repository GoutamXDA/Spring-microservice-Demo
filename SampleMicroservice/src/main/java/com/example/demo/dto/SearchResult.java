package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchResult {
	private String id;
	private String gradeID;
	private String gradeName;
	private String subjectID;
	private String subjectName;
	private String subjectCategoryID;
	private String subejctCategoryName;
	private String chapterID;
	private String chapterName;
	private String questionTypeID;
	private String questionTypeName;
	private String complexity;
	private String question;
}
