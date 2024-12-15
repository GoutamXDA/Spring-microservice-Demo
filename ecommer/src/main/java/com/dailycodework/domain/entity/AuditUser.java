package com.dailycodework.domain.entity;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="DS_USER")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
public class AuditUser extends AbstractEntity {
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private static final long serialVersionUID = 1L;
	private String dsPersonId;
	private String firstName;
	private String lastName;
	private String email;
	private String preferredName;
	private Boolean isPreferredNameDerived;
	
	public String getFullName() {
		String fullName;
		String last=Strings.nullToEmpty(lastName);
		Joiner joiner=Joiner.on(StringUtils.EMPTY);
		if(StringUtils.isNotBlank(preferredName)) {
			fullName=joiner.join(preferredName,last);
		}
		else {
			fullName=joiner.join(Strings.nullToEmpty(firstName),last);
		}
		return fullName;
	}
}
