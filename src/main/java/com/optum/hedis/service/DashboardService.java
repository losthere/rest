package com.optum.hedis.service;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.optum.hedis.domain.Audit;
import com.optum.hedis.domain.Claim;
import com.optum.hedis.domain.DashMeasureSummaryDef;
import com.optum.hedis.domain.DenominatorEadMetricDef;
import com.optum.hedis.domain.Exclusion;
import com.optum.hedis.domain.HdeMrrExclRsltCode;
import com.optum.hedis.domain.HybIdss;
import com.optum.hedis.domain.Idss;
import com.optum.hedis.domain.MeasAudit;
import com.optum.hedis.domain.MeasCodes;
import com.optum.hedis.domain.Measure;
import com.optum.hedis.domain.MeasureDetailDefAcc;
import com.optum.hedis.domain.MeasureMaster;
import com.optum.hedis.domain.MeasureSummaryDef;
import com.optum.hedis.domain.MeasureValueSet;
import com.optum.hedis.domain.Numerator;
import com.optum.hedis.domain.OhrMeasure;
import com.optum.hedis.domain.OhrNumerator;
import com.optum.hedis.domain.Pld;
import com.optum.hedis.domain.RunResultsDef;
import com.optum.hedis.domain.SampEmIdss;
import com.optum.hedis.domain.SampleSize;
import com.optum.hedis.domain.Users;
import com.optum.hedis.domain.VendorEvent;
import com.optum.hedis.domain.VendorNum;

public interface DashboardService {	
	String copyMeasure(Long fromYear, Long toYear, String measureCode);
	String confirmOnUserAuthorisation(String emailId);
	String confirmOnUserDeletion(String emailId);
	String deleteMeasure(String measureName, Long selectedYearToDeleteMeasure);
	String fileExport(String tableName, HttpServletResponse response);
	List<String> getAllMeasures();
	List<Object[]> getAllMeasureFromDefFiles(Long measureYearForMeasureCode);
	List<String> getAllTables(String tableType);
	List<Object[]> getSelectedTable(String tableName);
	List<Object[]> getUsersCredentials();
	String saveNewUser(Users userToAdd);
	List<String> getProductLineDetails();
	String saveOnAddOrEditMeasureInMeasureDetailDefAccTable(MeasureDetailDefAcc measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInMeasureMasterTable(MeasureMaster measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInOhrMeasureTable(OhrMeasure measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInOhrNumeratorTable(OhrNumerator measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInClaimTable(Claim measureRowToAddOrEdit);
    String saveOnAddOrEditMeasureInRunResultsDefTable(RunResultsDef measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInMeasureSummaryDefTable(MeasureSummaryDef measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInDashMeasureSummaryDefTable(DashMeasureSummaryDef measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInDenominatorEadMetricDefTable(DenominatorEadMetricDef measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInExclusionTable(Exclusion measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInIdssTable(Idss measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInMeasureTable(Measure measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInNumeratorTable(Numerator measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInPldTable(Pld measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInVendorNumTable(VendorNum measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInVendorEventTable(VendorEvent measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInSampleSizeTable(SampleSize measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInSampEmIdssTable(SampEmIdss measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInMeasureValueSetTable(MeasureValueSet measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInMeasCodesTable(MeasCodes measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInMeasAuditTable(MeasAudit measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInHybIdssTable(HybIdss measureRowToAddOrEdit);
	String saveOnAddOrEditMeasureInHdeMrrExclRsltCodeTable(HdeMrrExclRsltCode measureRowToAddOrEdit);
	String saveAudit(Audit audit);
	List<Object[]> getAudit();
}



