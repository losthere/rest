package com.optum.hedis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_LIST")
public class TableList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="TABLE_ID")
	private long tableId;
	
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@Column(name="TABLE_TYPE")
	private String tableType;
}
