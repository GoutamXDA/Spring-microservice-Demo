package com.example.demo.repository.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.SearchInput;
import com.example.demo.dto.SearchResult;
import com.example.demo.repository.QuestionRepository;
import com.mongodb.client.result.DeleteResult;

public class QuestionRepositoryImpl implements QuestionRepository {

	private MongoTemplate mongoTemplate;

	public QuestionRepositoryImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public QuestionDTO getQuestionByID(String id) {
		return mongoTemplate.findById(id, QuestionDTO.class);
	}

	@Override
	public boolean deleteQuestion(String id) {
		final Query query = Query.query(Criteria.where("_id").is(id));
		final DeleteResult deleteResult = mongoTemplate.remove(query, QuestionDTO.class);
		return deleteResult.getDeletedCount() == 1;
	}

	@Override
	public boolean isQuestionExists(String id) {
		final Query query=Query.query(Criteria.where("_id").is(id));
		final long count=mongoTemplate.count(query, QuestionDTO.class);
		return count==1;
	}

	@Override
	public QuestionDTO saveQuestion(QuestionDTO question) {
		return mongoTemplate.save(question);
	}

	@Override
    public List<SearchResult> searchQuestions(final SearchInput searchInput) {
        final Query query = new Query();
        if (StringUtils.isNotEmpty(searchInput.getId())) {
            query.addCriteria(Criteria.where("_id").is(searchInput.getId()));
        }
        if (StringUtils.isNotEmpty(searchInput.getGradeID())) {
            query.addCriteria(Criteria.where("gradeID").is(searchInput.getGradeID()));
        }
        if (StringUtils.isNotEmpty(searchInput.getSubjectID())) {
            query.addCriteria(Criteria.where("subjectID").is(searchInput.getSubjectID()));
        }
        if (StringUtils.isNotEmpty(searchInput.getSubjectCategoryID())) {
            query.addCriteria(Criteria.where("subjectCategoryID").is(searchInput.getSubjectCategoryID()));
        }
        if (StringUtils.isNotEmpty(searchInput.getChapterID())) {
            query.addCriteria(Criteria.where("chapterID").is(searchInput.getChapterID()));
        }
        if (StringUtils.isNotEmpty(searchInput.getQuestionTypeID())) {
            query.addCriteria(Criteria.where("questionTypeID").is(searchInput.getQuestionTypeID()));
        }
        if (StringUtils.isNotEmpty(searchInput.getComplexity())) {
            query.addCriteria(Criteria.where("complexity").is(searchInput.getComplexity()));
        }
        List<String> projection = List.of("_id", "gradeID", "subjectID", "subjectCategoryID", "chapterID", "questionTypeID", "question");
        projection.forEach(query.fields()::include);
        List<SearchResult> searchResults = mongoTemplate.find(query, SearchResult.class, "question");
        return searchResults;
    }
	
	@Override
	public long getNextSequence(final String sequenceKey) {
		return 01;
	}

}
