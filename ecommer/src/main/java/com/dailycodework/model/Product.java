package com.dailycodework.model;

import java.math.BigDecimal;
import java.util.List;

import com.dailycodework.domain.entity.AbstractAuditableEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="PRODUCT")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true, callSuper=false)
public class Product extends AbstractAuditableEntity {

	private static final long serialVersionUID=1L;
@Id
@SequenceGenerator(name="PRODUCT_GEN",sequenceName="PRODUCT_LOCALE_SEQ",allocationSize=1)
@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "PRODUCT_GEN")
@EqualsAndHashCode.Include
private Long id;
private String name;
private String brand;
private BigDecimal price;
private int inventory;
private String description;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="category_id")
private Category category;

@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
private List<Image> images;
}
