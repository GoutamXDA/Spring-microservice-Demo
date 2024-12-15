package com.dailycodework.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractEntity extends AbstractJPAEntity implements Serializable {

	private static final long serialVersionUID=1L;
	@Version
	@Column(nullable =false)
	private Long version=0L;
}
