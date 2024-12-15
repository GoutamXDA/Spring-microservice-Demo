package com.dailycodework.domain.entity;

import java.io.Serializable;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractJPAEntity implements Serializable {

	private static final long serailVesrionUID = 1L;
}
