package com.dailycodework;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.MultiValueMap;

import com.dailycodework.domain.entity.AbstractJPAEntity;

import jakarta.persistence.EntityManager;
@NoRepositoryBean
public interface CustomRepository<T extends AbstractJPAEntity, ID extends Serializable> 
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * Provides access to the underlying JPA EntityManager.
     * Useful for executing custom JPA queries that are not supported by the default repository methods.
     * 
     * @return the EntityManager instance.
     */
    EntityManager getEntityManager();

    /**
     * Finds all entities that match the given specification and returns a paginated result.
     * Supports a separate count specification for accurate total count calculation.
     *
     * @param spec the specification for filtering the entities.
     * @param countSpec the specification for counting entities.
     * @param pageable the pagination details.
     * @return a page containing the matching entities.
     */
    Page<T> findAll(Specification<T> spec, Specification<T> countSpec, Pageable pageable);

    /**
     * Finds a single entity that matches the given specification and identifier.
     * 
     * @param specification the specification defining the search criteria.
     * @param identifier an additional identifier for further filtering.
     * @return the entity matching the criteria, or {@code null} if no match is found.
     */
    T findOne(Specification<T> specification, Object identifier);

    /**
     * Retrieves an entity using its primary key.
     * 
     * @param id the primary key of the entity.
     * @return the entity associated with the given primary key.
     */
    T findByPrimaryKey(ID id);

    /**
     * Finds an entity by its unique UUID.
     * 
     * @param uuid the unique identifier of the entity.
     * @return an Optional containing the entity if found, or empty if not found.
     */
    Optional<T> findByUuid(String uuid);

    /**
     * Finds entities that match the given specification within a specific time range.
     * 
     * @param spec the specification defining the search criteria.
     * @param timeDifferenceInMillis the time range in milliseconds for filtering entities.
     * @param pageable the pagination details.
     * @return a page containing the entities that match the specification and time range.
     */
    Page<T> findBySpecInTimeRange(Specification<T> spec, long timeDifferenceInMillis, Pageable pageable);

    /**
     * Searches for entities based on the provided search parameters and returns a paginated result.
     * 
     * @param allRequestParams the search parameters as key-value pairs.
     * @param pageable the pagination details.
     * @return a page containing the search results.
     */
    Page<T> getBySearchParam(MultiValueMap<String, String> allRequestParams, Pageable pageable);

    /**
     * Finds a list of entities using their UUIDs.
     * 
     * @param uuids the list of UUIDs for the entities to retrieve.
     * @return a list of entities matching the given UUIDs.
     */
    List<T> findByUuids(List<String> uuids);

    /**
     * Counts the number of entities that match the given specification.
     * 
     * @param spec the specification defining the search criteria.
     * @return the count of entities matching the specification.
     */
    long countBySpec(Specification<T> spec);
}


