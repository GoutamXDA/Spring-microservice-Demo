package com.dailycodework.domain.entity;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.threeten.bp.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Data
@EqualsAndHashCode
public abstract class AbstractAuditableEntity  extends AbstractEntity{

	private static final long serialVesrionUID=1L;
	public static final String DEFAULT_NOT_RETIRED="N";
	
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@CreatedBy
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CREATED_BY",updatable=false)
	private AuditUser createdByUser;
	
	@Audited
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE",updatable = false)
	private OffsetDateTime createdDate;
	
	@Audited(targetAuditMode =RelationTargetAuditMode.NOT_AUDITED)
	@LastModifiedBy
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MODIFIED_BY")
	private AuditUser modifiedByUser;
	
	@Audited
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	private OffsetDateTime modifiedDate;
	
	@Column(name="RETIRED",columnDefinition="CHAR")
	private String retired=DEFAULT_NOT_RETIRED;
	
	@PrePersist
	public void prePersist() {
		if(retired==null)
			retired="N";
	}
}
 