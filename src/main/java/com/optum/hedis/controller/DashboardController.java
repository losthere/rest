package com.optum.hedis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optum.hedis.constants.RequestResource;
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
import com.optum.hedis.service.DashboardService;

@RestController
@RequestMapping(value = RequestResource.DASHBOARD)
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;  

	@RequestMapping(value = RequestResource.COPY_MEASURE)
	public String copyMeasure(@RequestParam Long fromYear, @RequestParam Long toYear, @RequestParam String measureCode) {
		dashboardService.copyMeasure(fromYear, toYear, measureCode);
		return "";
	}
	
	@RequestMapping(value = RequestResource.CONFIRM_ON_USER_AUTHENTICATION)
	public String confirmOnUserAuthorisation(@RequestParam String emailId) {
		dashboardService.confirmOnUserAuthorisation(emailId);
		return "";
	}
	
	@RequestMapping(value = RequestResource.CONFIRM_ON_USER_DELETION )
	public String confirmOnUserDeletion(@RequestParam String emailId) {
		dashboardService.confirmOnUserDeletion(emailId);
		return "";
	}
	
	@RequestMapping(value = RequestResource.DELETE_MEASURE)
	public String deleteMeasure(@RequestParam String measureName, @RequestParam Long selectedYearToDeleteMeasure, HttpServletRequest request) {
		dashboardService.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		return "";
	}
	
	@RequestMapping(value = RequestResource.FILE_EXPORT)	
	public String fileExport(HttpServletRequest request, HttpServletResponse response, @RequestParam String tableName) {
		dashboardService.fileExport(tableName, response);
		return "";		
	}
	
	@RequestMapping(value = RequestResource.GET_ALL_MEASURES)
	public List<String> getAllMeasures(HttpServletRequest request) {
    	return dashboardService.getAllMeasures();
	}
	
	@RequestMapping(value = "/getAllMeasureFromDefFiles")
	public List<Object[]> getAllMeasureFromDefFiles(HttpServletRequest request, @RequestParam Long measureYearForMeasureCode) {
    	return dashboardService.getAllMeasureFromDefFiles(measureYearForMeasureCode);
	}
		
	@RequestMapping(value = RequestResource.GET_ALL_TABLES)
	public List<String> getAllTables(HttpServletRequest request, @RequestParam String tableType) {
    	return dashboardService.getAllTables(tableType);
	}
	
	@RequestMapping(value = RequestResource.GET_AUDIT)
	public List<Object[]> getAuditData() {
		return dashboardService.getAudit();	
	}
    
    @RequestMapping(value = RequestResource.GET_SELECTED_TABLE)
	public List<Object[]> getSelectedTable(@RequestParam String tableName, HttpServletRequest request) {
		return dashboardService.getSelectedTable(tableName);
	}  	
	
	@RequestMapping(value = RequestResource.GET_USER_CREDENTIALS)
	public List<Object[]> getUsersCredentials(HttpServletRequest request) {
    	return dashboardService.getUsersCredentials();
	}
	
	@RequestMapping(value = RequestResource.SAVE_AUDIT)
	public String saveAudit(@RequestBody Audit audit) {
		dashboardService.saveAudit(audit);	
		return "";
	}	

	@RequestMapping(value = RequestResource.SAVE_NEW_USER)
	public String saveNewUser(@RequestBody Users userToAdd, HttpServletRequest request) {
    	dashboardService.saveNewUser(userToAdd); 
    	return "";
    }
	
	@RequestMapping(value = "/getProductLineDetails")
	public List<String> getProductLineDetails() {
    	return dashboardService.getProductLineDetails(); 
    }
	
	
	@RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_DASH_MEASURE_SUMMARY_DEF_TABLE)
	public String saveOnAddOrEditMeasureInDashMeasureSummaryDefTable(@RequestBody DashMeasureSummaryDef measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInDashMeasureSummaryDefTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_MEASURE_SUMMARY_DEF_TABLE)
	public String saveOnAddOrEditMeasureInMeasureSummaryDefTable(@RequestBody MeasureSummaryDef measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInMeasureSummaryDefTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_MEASURE_DETAIL_DEF_ACC_TABLE)
	public String saveOnAddOrEditMeasureInMeasureDetailDefAccTable(@RequestBody MeasureDetailDefAcc measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInMeasureDetailDefAccTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_CLAIM_TABLE)
	public String saveOnAddOrEditMeasureInClaimTable(@RequestBody Claim measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInClaimTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_RUN_RESULTS_TABLE)
	public String saveOnAddOrEditMeasureInRunResultsDefTable(@RequestBody RunResultsDef measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInRunResultsDefTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_DENOMINATOR_EAD_METRIC_DEF_TABLE)
	public String saveOnAddOrEditMeasureInDenominatorEadMetricDefTable(@RequestBody DenominatorEadMetricDef measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInDenominatorEadMetricDefTable(measureRowToAddOrEdit); 
    	return "";
    }
	
    @RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_EXCLUSION_TABLE)
	public String saveOnAddOrEditMeasureInExclusionTable(@RequestBody Exclusion measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInExclusionTable(measureRowToAddOrEdit); 
    	return "";
    }
    
    @RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_IDSS_TABLE)
	public String saveOnAddOrEditMeasureInIdssTable(@RequestBody Idss measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInIdssTable(measureRowToAddOrEdit); 
    	return "";
    }
    
    @RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_MEASURE_TABLE)
	public String saveOnAddOrEditMeasureInMeasureTable(@RequestBody Measure measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInMeasureTable(measureRowToAddOrEdit); 
    	return "";
    }
    
/*    @RequestMapping(value = "/saveOnAddOrEditMeasureInMeasureMasterTable")
 	public String saveOnAddOrEditMeasureInMeasureMasterTable(@RequestBody MeasureMaster measureRowToAddOrEdit, HttpServletRequest request) {
     	dashboardService.saveOnAddOrEditMeasureInMeasureMasterTable(measureRowToAddOrEdit); 
     	return "";
     }*/
    
    @RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_NUMERATOR_TABLE)
	public String saveOnAddOrEditMeasureInNumeratorTable(@RequestBody Numerator measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInNumeratorTable(measureRowToAddOrEdit); 
    	return "";
    }
    
    @RequestMapping(value = RequestResource.SAVE_ON_ADD_OR_EDIT_MEASURE_IN_PLD_TABLE)
	public String saveOnAddOrEditMeasureInPldTable(@RequestBody Pld measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInPldTable(measureRowToAddOrEdit); 
    	return "";
    }
    
    @RequestMapping(value = "/saveOnAddOrEditMeasureInHdeMrrExclRsltCodeTable")
	public String saveOnAddOrEditMeasureInHdeMrrExclRsltCodeTable(@RequestBody HdeMrrExclRsltCode measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInHdeMrrExclRsltCodeTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInMeasureValueSetTable")
	public String saveOnAddOrEditMeasureInMeasureValueSetTable(@RequestBody MeasureValueSet measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInMeasureValueSetTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInSampEmIdssTable")
	public String saveOnAddOrEditMeasureInSampEmIdssTable(@RequestBody SampEmIdss measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInSampEmIdssTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInSampleSizeTable")
	public String saveOnAddOrEditMeasureInSampleSizeTable(@RequestBody SampleSize measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInSampleSizeTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInVendorEventTable")
	public String saveOnAddOrEditMeasureInVendorEventTable(@RequestBody VendorEvent measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInVendorEventTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInVendorNumTable")
	public String saveOnAddOrEditMeasureInVendorNumTable(@RequestBody VendorNum measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInVendorNumTable(measureRowToAddOrEdit); 
    	return "";
    }
    
    @RequestMapping(value = "/saveOnAddOrEditMeasureInMeasAuditTable")
	public String saveOnAddOrEditMeasureInMeasAuditTable(@RequestBody MeasAudit measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInMeasAuditTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInMeasCodesTable")
	public String saveOnAddOrEditMeasureInMeasCodesTable(@RequestBody MeasCodes measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInMeasCodesTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInHybIdssTable")
	public String saveOnAddOrEditMeasureInHybIdssTable(@RequestBody HybIdss measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInHybIdssTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value = "/saveOnAddOrEditMeasureInOhrNumeratorTable")
	public String saveOnAddOrEditMeasureInOhrNumeratorTable(@RequestBody OhrNumerator measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInOhrNumeratorTable(measureRowToAddOrEdit); 
    	return "";
    }
	
	@RequestMapping(value ="/saveOnAddOrEditMeasureInOhrMeasureTable")
	public String saveOnAddOrEditMeasureInOhrMeasureTable(@RequestBody OhrMeasure measureRowToAddOrEdit, HttpServletRequest request) {
    	dashboardService.saveOnAddOrEditMeasureInOhrMeasureTable(measureRowToAddOrEdit); 
    	return "";
    }
}
