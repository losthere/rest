package com.optum.hedis.constants;

public final class RequestResource {

	// To avoid object creation
	private RequestResource() {

	}
	// Common operations
	public static final String COPY_MEASURE = "/copyMeasure";
	public static final String CONFIRM_ON_USER_AUTHENTICATION = "/confirmOnUserAuthorisation";
	public static final String CONFIRM_ON_USER_DELETION = "/confirmOnUserDeletion";
	public static final String DASHBOARD = "/dashboard";
	public static final String DELETE_MEASURE = "/deleteMeasure";
	public static final String FILE_EXPORT = "/fileExport";
	public static final String GET_ALL_MEASURES = "/getAllMeasures";
	public static final String GET_ALL_TABLES = "/getAllTables";
	public static final String GET_AUDIT = "/getAudit";
	public static final String GET_SELECTED_TABLE = "/getSelectedTable";
	public static final String GET_USER_CREDENTIALS = "/getUsersCredentials";
	
	public static final String SAVE_AUDIT = "/saveAudit";
	public static final String SAVE_NEW_USER = "/saveNewUser";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_DENOMINATOR_EAD_METRIC_DEF_TABLE = "/saveOnAddOrEditMeasureInDenominatorEadMetricDefTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_MEASURE_DETAIL_DEF_ACC_TABLE = "/saveOnAddOrEditMeasureInMeasureDetailDefAccTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_DASH_MEASURE_SUMMARY_DEF_TABLE = "/saveOnAddOrEditMeasureInDashMeasureSummaryDefTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_MEASURE_SUMMARY_DEF_TABLE = "/saveOnAddOrEditMeasureInMeasureSummaryDefTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_RUN_RESULTS_TABLE = "/saveOnAddOrEditMeasureInRunResultsDefTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_CLAIM_TABLE = "/saveOnAddOrEditMeasureInClaimTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_HDE_MEAS_AUDIT_CW_TABLE = "/saveOnAddOrEditMeasureInHdeMeasAuditCwTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_EXCLUSION_TABLE = "/saveOnAddOrEditMeasureInExclusionTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_IDSS_TABLE = "/saveOnAddOrEditMeasureInIdssTable";
	
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_MEASURE_TABLE = "/saveOnAddOrEditMeasureInMeasureTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_NUMERATOR_TABLE = "/saveOnAddOrEditMeasureInNumeratorTable";
	public static final String SAVE_ON_ADD_OR_EDIT_MEASURE_IN_PLD_TABLE = "/saveOnAddOrEditMeasureInPldTable";
}
