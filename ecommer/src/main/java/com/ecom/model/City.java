package com.ecom.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CITY")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="CITY")
	private String city;
	@Column(name="POPULATION")
	private Long population;
}
