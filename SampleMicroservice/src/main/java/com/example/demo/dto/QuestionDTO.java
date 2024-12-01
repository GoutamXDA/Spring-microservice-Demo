package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

	private String id;
	private String gradeID;
	private String subjectId;
	private String subjectCategoryID;
	private String chapterID;
	private String questionTypeID;
	private String statusID;
	private String complexity;
	private String question;
	private String answer;
	private String createdBy;
	private Date createdTime;
	private String lastModifiedBy;
	private Date lastModifiedDate;
}
