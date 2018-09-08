package com.optum.hedis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The primary key class for the NCQA_NUMERATORS database table.
 **/

@Embeddable
public class NumeratorPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonInclude
	@Column(name="MEASUREMENT_YR")
	private long measurementYr;

	@JsonInclude
	@Column(name="STRATIFICATION_ID")
	private String stratificationId;
}
