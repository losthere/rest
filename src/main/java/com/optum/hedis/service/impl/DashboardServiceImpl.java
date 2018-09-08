package com.optum.hedis.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.optum.hedis.service.DashboardService;
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
import com.optum.hedis.repository.AuditRepository;
import com.optum.hedis.repository.ClaimRepository;
import com.optum.hedis.repository.DashMeasureSummaryDefRepository;
import com.optum.hedis.repository.DenominatorEadMetricDefRepository;
import com.optum.hedis.repository.ExclusionRepository;
import com.optum.hedis.repository.HdeMrrExclRsltCodeRepository;
import com.optum.hedis.repository.HybIdssRepository;
import com.optum.hedis.repository.IdssRepository;
import com.optum.hedis.repository.MeasAuditRepository;
import com.optum.hedis.repository.MeasCodesRepository;
import com.optum.hedis.repository.MeasureDetailDefAccRepository;
import com.optum.hedis.repository.MeasureMasterRepository;
import com.optum.hedis.repository.MeasureRepository;
import com.optum.hedis.repository.MeasureSummaryDefRepository;
import com.optum.hedis.repository.MeasureValueSetRepository;
import com.optum.hedis.repository.NumeratorRepository;
import com.optum.hedis.repository.OhrMeasureRepository;
import com.optum.hedis.repository.OhrNumeratorRepository;
import com.optum.hedis.repository.PldRepository;
import com.optum.hedis.repository.RunResultsDefRepository;
import com.optum.hedis.repository.SampEmIdssRepository;
import com.optum.hedis.repository.SampleSizeRepository;
import com.optum.hedis.repository.TableListRepository;
import com.optum.hedis.repository.UsersListRepository;
import com.optum.hedis.repository.VendorEventRepository;
import com.optum.hedis.repository.VendorNumRepository;
import com.optum.hedis.util.DataExportUtil;
import com.optum.hedis.util.EmailNotificationUtil;

@Service
public class DashboardServiceImpl implements DashboardService {	   
	
	private static final Logger LOG = Logger.getLogger(DashboardServiceImpl.class);

	@Autowired
    private AuditRepository auditRepository;
	
	@Autowired
   	private ClaimRepository claimRepository;
	
	@Autowired
   	private RunResultsDefRepository runResultsDefRepository;
	
	@Autowired
   	private MeasureSummaryDefRepository measureSummaryDefRepository;
	
	@Autowired
	private DenominatorEadMetricDefRepository denominatorEadMetricDefRepository;
	
	@Autowired
	private OhrNumeratorRepository ohrNumeratorRepository;
	
	@Autowired
	private DataExportUtil fileExportUtil;
	
	@Autowired
	private EmailNotificationUtil emailNotificationUtil; 

	@Autowired
   	private ExclusionRepository exclusionRepository;
		
	@Autowired
    private MeasureDetailDefAccRepository measureDetailDefAccRepository;
	
	
	@Autowired
	private OhrMeasureRepository ohrMeasureRepository;
    
	@Autowired
   	private IdssRepository idssRepository;
	
	@Autowired
   	private MeasureMasterRepository measureMasterRepository;
	
    @Autowired
   	private MeasureRepository measureRepository;
    
    @Autowired
   	private DashMeasureSummaryDefRepository dashMeasureSummaryDefRepository;
    
    @Autowired
   	private PldRepository pldRepository;
    
    @Autowired
   	private SampleSizeRepository sampleSizeRepository;
    
    @Autowired
   	private MeasureValueSetRepository measureValueSetRepository;
    
    @Autowired
   	private VendorEventRepository vendorEventRepository;
    
    @Autowired
   	private VendorNumRepository vendorNumRepository;
    
    @Autowired
   	private HdeMrrExclRsltCodeRepository hdeMrrExclRsltCodeRepository;
    
    @Autowired
   	private SampEmIdssRepository sampEmIdssRepository;
    
    @Autowired
   	private NumeratorRepository numeratorRepository;
    
    @Autowired
   	private MeasAuditRepository measAuditRepository;
    
    @Autowired
   	private MeasCodesRepository measCodesRepository;
    
    @Autowired
   	private HybIdssRepository hybIdssRepository;
    
    @Autowired
   	private TableListRepository tableListRepository;
    
    @Autowired
    private UsersListRepository usersListRepository;
	
	public DashboardServiceImpl() {
		super();
	}
	
	@Override
	@Transactional
	public String confirmOnUserAuthorisation(String emailId) {
		usersListRepository.confirmOnUserAuthorisation(emailId);
		return "";
	}
	
	@Override
	@Transactional
	public String confirmOnUserDeletion(String emailId) {
		usersListRepository.confirmOnUserDeletion(emailId);
		return "";
	}
	
	@Override
	@Transactional
	public String copyMeasure(Long fromYear, Long toYear, String measureCode) {
		System.out.println("hggjkggjgjkgk" +measureCode);
		claimRepository.copyMeasure(fromYear, toYear, measureCode);
		measureRepository.copyMeasure(fromYear, toYear, measureCode);
		idssRepository.copyMeasure(fromYear, toYear, measureCode);
		sampleSizeRepository.copyMeasure(fromYear, toYear, measureCode);
		measureValueSetRepository.copyMeasure(fromYear, toYear, measureCode);
		hdeMrrExclRsltCodeRepository.copyMeasure(fromYear, toYear, measureCode);
		sampEmIdssRepository.copyMeasure(fromYear, toYear,  measureCode);
	//	numeratorRepository.copyMeasure(fromYear, toYear);
		measAuditRepository.copyMeasure(fromYear, toYear,  measureCode);
		measCodesRepository.copyMeasure(fromYear, toYear,  measureCode);
		hybIdssRepository.copyMeasure(fromYear, toYear, measureCode);
		//runResultsDefRepository.copyMeasure(fromYear, toYear);
		//measureSummaryDefRepository.copyMeasure(fromYear, toYear);
		//dashMeasureSummaryDefRepository.copyMeasure(fromYear, toYear);
		//denominatorEadMetricDefRepository.copyMeasure(fromYear, toYear);
		//measureDetailDefAccRepository.copyMeasure(fromYear, toYear);
	//ohrMeasureRepository.copyMeasure(fromYear, toYear);
		return "";
	}
	
	@Override
	@Transactional
	public String deleteMeasure(String measureName, Long selectedYearToDeleteMeasure) {
		//measureMasterRepository.deleteMeasure(measureName, Long.toString(selectedYearToDeleteMeasure));
		claimRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		exclusionRepository.deleteMeasure(measureName);
		idssRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		measureRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		pldRepository.deleteMeasure(measureName);
		vendorEventRepository.deleteMeasure(measureName);
		vendorNumRepository.deleteMeasure(measureName);
		sampleSizeRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		measureValueSetRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		hdeMrrExclRsltCodeRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		sampEmIdssRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		numeratorRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		measAuditRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		measCodesRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		hybIdssRepository.deleteMeasure(measureName, selectedYearToDeleteMeasure);
		Long measureId = measureMasterRepository.getMeasureId(measureName, selectedYearToDeleteMeasure);
		//runResultsDefRepository.deleteMeasure(measureId, Long.toString(selectedYearToDeleteMeasure));
		measureDetailDefAccRepository.deleteMeasure(measureId, Long.toString(selectedYearToDeleteMeasure));
		dashMeasureSummaryDefRepository.deleteMeasure(measureId, Long.toString(selectedYearToDeleteMeasure));
		denominatorEadMetricDefRepository.deleteMeasure(measureId, Long.toString(selectedYearToDeleteMeasure));
		measureSummaryDefRepository.deleteMeasure(measureId, Long.toString(selectedYearToDeleteMeasure));
		ohrMeasureRepository.deleteMeasure(measureId, Long.toString(selectedYearToDeleteMeasure));
		ohrNumeratorRepository.deleteMeasure(measureId);
		
		return "";
	}
	
	@Override
	@Transactional
	public String fileExport(String tableName, HttpServletResponse response) {
		List<Object[]> tableToBeExported = new ArrayList<Object[]>();
		
		if(tableName.equals("HDE CLAIM ID XWALK"))
			tableToBeExported = claimRepository.getClaimTableForExport();
		else if(tableName.equals("HDE EXCLUSIONS XWALK"))
			tableToBeExported = exclusionRepository.getExclusionTableForExport();
		else if(tableName.equals("HDE PLD MEASURE XWALK"))
			tableToBeExported = pldRepository.getPldTableForExport();	
		else if(tableName.equals("NCQA IDSS XWALK"))
			tableToBeExported = idssRepository.getIdssTableForExport();
		else if(tableName.equals("NCQA MEASURES"))
			tableToBeExported = measureRepository.getMeasureTableForExport();	
		else if(tableName.equals("DASH MEASURE SUMMARY DEF"))
			tableToBeExported = dashMeasureSummaryDefRepository.getDashMeasureSummaryDefTableForExport();
		else if(tableName.equals("RUN RESULTS DEF"))
			tableToBeExported = runResultsDefRepository.getRunResultsDefTableForExport();
		else if(tableName.equals("DENOMINATOR EAD METRIC DEF"))
			tableToBeExported = denominatorEadMetricDefRepository.getdenominatorEadMetricDefTableForExport();
		else if(tableName.equals("MEASURE DETAIL DEF ACC"))
			tableToBeExported = measureDetailDefAccRepository.getMeasureDetailDefAccTableForExport();
		/*else if(tableName.equals("MEASURE MASTER"))
			tableToBeExported = measureMasterRepository.getMeasureMasterTableForExport();*/
		else if(tableName.equals("MEASURE"))
			tableToBeExported = ohrMeasureRepository.getohrMeasureTableForExport();
		else if(tableName.equals("NUMERATOR"))
			tableToBeExported = ohrNumeratorRepository.getohrNumeratorTableForExport();
		else if(tableName.equals("MEASURE SUMMARY DEF"))
			tableToBeExported = measureSummaryDefRepository.getMeasureSummaryDefTableForExport();
		else if(tableName.equals("NCQA SAMPLE SIZE"))
			tableToBeExported = sampleSizeRepository.getSampleSizeTableForExport();
		else if(tableName.equals("NCQA MEASURES TO VALUESETS"))
			tableToBeExported = measureValueSetRepository.getMeasureValueSetTableForExport();
		else if(tableName.equals("HDE VENDOR EVENT XWALK"))
			tableToBeExported = vendorEventRepository.getVendorEventTableForExport();
		else if(tableName.equals("HDE VENDOR NUM XWALK"))
			tableToBeExported = vendorNumRepository.getVendorNumTableForExport();
		else if(tableName.equals("HDE MRR EXCL RSLT CODE"))
			tableToBeExported = hdeMrrExclRsltCodeRepository.getHdeMrrExclRsltCodeTableForExport();
		else if(tableName.equals("SAMP EM IDSS XWALK"))
			tableToBeExported = sampEmIdssRepository.getSampEmIdssTableForExport();
		else if(tableName.equals("NCQA NUMERATORS"))
			tableToBeExported = numeratorRepository.getNumeratorTable();
		else if(tableName.equals("HDE MEAS AUDIT CW"))
			tableToBeExported = measAuditRepository.getMeasAuditTable();
		else if(tableName.equals("OHM MEAS CODES"))
			tableToBeExported = measCodesRepository.getMeasCodesTable();
		else if(tableName.equals("NCQA HYB IDSS XWALK"))
			tableToBeExported = hybIdssRepository.getHybIdssTable();
		
		fileExportUtil.createWorkBookForExcelFile(tableToBeExported,response);
		try {
			response.getOutputStream().flush();
		}
		catch (IOException e) {
			LOG.error("Error while exporting xwalk table data to xls : " + e);
			}
		return "";
	}
	
	@Override
	public List<String> getAllMeasures() {
		return measureRepository.getAllMeasures();
	}
	
	@Override
	public List<String> getAllTables(String tableType) {
		if(tableType.equals("HDE XWALK TABLES"))
			return tableListRepository.getAllXWalkTables();
		else 
			return tableListRepository.getAllDefFileTables();
			
	}
	
	@Override
	public  List<Object[]> getAudit() {
		return auditRepository.getAudit();
	}
	
	@Override
	public List<Object[]> getSelectedTable(String tableName) {
		List<Object[]> selectedTable = new ArrayList<Object[]>();
		List<Object[]> selectedFullTable = new ArrayList<Object[]>();
		
		if(tableName.equals("HDE CLAIM ID XWALK"))
		{
			selectedTable = claimRepository.getClaimTable();
			selectedFullTable = claimRepository.getClaimFullTable();
			Object[] columnName = {"MEASURE NAME*", "NUMERATOR ID*", "DEN CLAIM METRIC CODE", "NUM CLAIM METRIC CODE", "EXCLUSION CLAIM METRIC CODE", "REPORTING YEAR"};
			Object[] columnPojo = {"measureName", "numeratorId", "denClaimMetricCode", "numClaimMetricCode", "exclusionClaimMetricCode", "reportingYr"};
			Object[] columnShow = {"measureName", "numeratorId", "denClaimMetricCode", "numClaimMetricCode", "exclusionClaimMetricCode", "reportingYr"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		
		else if(tableName.equals("MEASURE"))
		{
			selectedTable = ohrMeasureRepository.getohrMeasureTable();
			selectedFullTable = ohrMeasureRepository.getohrMeasureFullTable();
			Object[] columnName = {"MEASURE ID*", "MEASURE CODE*", "MEASURE NAME", "MEASURE YEAR", "DOMAINID", "HASHYBRID", "ISACTIVE" , "ISCOMMERCIAL", "ISMEDICAID", "ISMEDICARE", "ISMARKETPLACE", "ISSNP" ,"NUMCNT", "RUNTYPE", "STORETYPE", "SUBDOMAINID", "ISSTARS" ,"ISNONHEDIS", "SOURCE TYPE", "MANUAL ENTRY IND", "ISPLD", "CREAT USER*", "CREAT TMSTMP*", "UPDT USER", "UPDT TMSTMP", "P4P MEASURE CODE"};
			Object[] columnPojo = {"measureId", "measureCode", "measureName", "measureYear", "domainId", "hasHybrid", "isActive", "isCommercial", "isMedicaid", "isMedicare", "isMarketPlace", "isSnp", "numCnt", "runType", "storeType", "subDomainId", "isStars", "isNonHedis", "sourceType", "manualEntryInd", "isPld", "createUser", "creatTmstmp", "updtUser", "updtTmstmp", "p4pMeasureCode"};
			Object[] columnShow = {"MEASURE CODE", "MEASURE NAME", "MEASURE YEAR", "DOMAINID", "HASHYBRID", "ISACTIVE" , "ISCOMMERCIAL", "ISMEDICAID", "ISMEDICARE", "ISMARKETPLACE", "ISSNP" ,"NUMCNT", "RUNTYPE", "STORETYPE", "SUBDOMAINID", "ISSTARS" ,"SOURCE TYPE", "MANUAL ENTRY IND", "ISPLD", "P4P MEASURE CODE"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		
		else if(tableName.equals("NUMERATOR"))
		{
			selectedTable = ohrNumeratorRepository.getohrNumeratorTable();
			selectedFullTable = ohrNumeratorRepository.getohrNumeratorFullTable();
			Object[] columnName = {"NUMERATOR ID*", "MEASURE CODE*", "NUMERATOR CODE*", "NUMERATOR NAME", "SCORE TYPE", "BENEFITID", "EXTIDENT", "HASCOMORBID", "ISACTIVE", "ISPARENT", "ISSHOWN", "PARENTID", "SHORTDESCR", "STRATAGEID", "STRATID", "DISPLAY SORT BY", "MIN VALUE" ,"MAX VALUE", "RATE TYPE", "RATE DATA TYPE", "TREND GRAPH IND", "GOAL ENTRY IND", "PREV COMPARE IND", "NUMERATOR DETAIL", "ISMARKETPLACE","CREAT USER*","CREAT TMSTMP*", "UPDT USER" ,"UPDT TMSTMP", "NUM CODE" ,"ISCOMMERCIAL", "ISMEDICARE" ,"ISMEDICAID" ,"ISSNP" ,"P4P MEASURE CODE"};
			Object[] columnPojo = {"numeratorId", "measureId", "numeratorCode", "numeratorName", "scoreType", "benefitid", "extident", "hasComorbid", "isActive", "isParent", "isShown", "parentId", "shortDescr", "stratageId", "stratId", "displaySortBy", "minValue", "maxValue", "rateType", "rateDataType", "trendGraphInd", "goalEntryInd", "prevCompareInd", "numeratorDetail", "isMarketPlace", "createUser", "creatTmstmp", "updtUser", "updtTmstmp", "numCode", "isCommercial", "isMedicare", "isMedicaid", "isSnp", "p4pMeasureCode"};
			Object[] columnShow = {"MEASUREMENT YEAR", "MEASURE CODE","NUMERATOR CODE","NUMERATOR NAME", "SCORE TYPE","ISACTIVE", "SHORTDESCR", "MIN VALUE" ,"MAX VALUE", "RATE TYPE", "TREND GRAPH IND", "GOAL ENTRY IND", "PREV COMPARE IND", "User Friendly Description", "ISMARKETPLACE","ISCOMMERCIAL", "ISMEDICARE" ,"ISMEDICAID" ,"ISSNP" ,"P4P MEASURE CODE"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		
		else if(tableName.equals("MEASURE MASTER"))
		{
			selectedTable = measureMasterRepository.getMeasureMasterTable();
			selectedTable = measureMasterRepository.getMeasureMasterFullTable();
			Object[] columnName = {"MEASURE ID", "MEASURE CODE", "MEASURE NAME", "MEASURE YEAR", "DOMAINID", "HASHYBRID", "ISACTIVE", "ISCOMMERCIAL", "ISMEDICAID", "ISMEDICARE", "ISMARKETPLACE", "ISSNP", "NUMCNT", "RUNTYPE", "STORETYPE", "SUBDOMAINID", "ISSTARS", "ISNONHEDIS" ,"SOURCE TYPE", "MANUAL ENTRY IND", "ISPLD", "CREAT USER" ,"CREAT TMSTMP", "UPDT USER", "UPDT TMSTMP" ,"P4P MEASURE CODE"};
			Object[] columnPojo = {"measureId", "measureCode", "measureName", "measureYear", "domainId", "hasHybrid", "isActive", "isCommercial", "isMedicaid", "isMedicare", "isMarketPlace", "isSnp", "numCnt", "runType", "storeType", "subDomainId", "isStars", "isNonhedis", "sourceType", "manualEntryInd", "isPld", "createUser", "createTmstmp", "updtUser", "updtTmstmp", "p4pMeasureCode"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
		}
		
		else if(tableName.equals("DENOMINATOR EAD METRIC DEF"))
		{
			selectedTable = denominatorEadMetricDefRepository.getdenominatorEadMetricDefTable();
			selectedFullTable = denominatorEadMetricDefRepository.getdenominatorEadMetricDefFullTable();
			Object[] columnName = {"DENOMINATOR EAD METRIC DEF ID*", "MEASURE CODE*", "METRIC CODE*", "METRIC NAME*", "NUMERATOR CODE", "CREAT TMSTMP*", "CREAT USER*", "MEASURE YEAR", "MEASURE SET"};
			Object[] columnPojo = {"denominatorEadMetricDefId", "measureId", "metricCode", "metricName", "numeratorCode", "creatTmstmp", "createUser", "measureYear", "measureSet"};
			Object[] columnShow = {"MEASURE", "METRIC CODE", "METRIC", "NUMERATOR CODE", "MEASURE YEAR", "MEASURE SET"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		
		else if(tableName.equals("MEASURE DETAIL DEF ACC"))
		{
			selectedTable = measureDetailDefAccRepository.getmeasureDetailDefAccTable();
			selectedFullTable = measureDetailDefAccRepository.getmeasureDetailDefAccFullTable();
			Object[] columnName = {"MEASURE DETAIL DEF ID*","MEASURE CODE*", "METRIC CODE*", "METRIC NAME", "PROCESSING RULE", "TBL", "FLD", "NUMERATOR CODE", "METRIC ORDER", "CREAT TMSTMP*", "CREAT USER*", "UPDT TMSTMP", "UPDT USER", "MEASURE YEAR", "MEASURE SET NAME"};
			Object[] columnPojo = {"measureDetailDefId", "measureId", "metricCode", "metricName", "processingRule", "tbl", "fld", "numeratorCode", "metricOrder", "creatTmstmp","createUser","updtTmstmp","updtUser","measureYear", "measureSetName"};
			Object[] columnShow = {"MEASURE", "METRIC CODE*", "METRIC NAME", "PROCESSING RULE", "TBL", "NUMERATOR CODE", "METRIC ORDER","MEASURE YEAR", "MEASURE SET"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		
		else if(tableName.equals("DASH MEASURE SUMMARY DEF"))
		{
			selectedTable = dashMeasureSummaryDefRepository.getdashMeasureSummaryDefTable();
			selectedFullTable = dashMeasureSummaryDefRepository.getdashMeasureSummaryDefFullTable();
			Object[] columnName = {"DASH MEASURE SUMMARY DEF ID*", "MEASURE CODE*", "MEASURE TYPE", "CATEGORY", "CATEGORY TREND", "CATEGORY VALUE", "CALC TYPE", "SERIES NAME", "DISPLAY LABEL", "SORT ORDER", "VALUE", "NUMERATOR ID", "DISPLAY TYPE", "CREAT USER*" ,"CREAT TMSTMP*", "UPDT USER", "UPDT TMSTMP", "MEASURE YEAR"};
			Object[] columnPojo = {"dashMeasureSummaryDefId", "measureId", "measureType", "category", "categoryTrend", "categoryValue", "calcType", "seriesName" , "displayLabel", "sortOrder", "value", "numeratorId", "displayType", "createUser", "creatTmstmp", "updtUser", "updtTmstmp", "measureYear"};
			Object[] columnShow = {"MEASURE CODE*", "MEASURE TYPE", "SERIES NAME", "DISPLAY LABEL", "SORT ORDER", "VALUE", "NUMERATOR CODE", "DISPLAY TYPE", "MEASURE YEAR"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);

		}
		
		else if(tableName.equals("MEASURE SUMMARY DEF"))
		{
			selectedTable = measureSummaryDefRepository.getmeasureSummaryDefTable();
			selectedFullTable = measureSummaryDefRepository.getmeasureSummaryDefFullTable();
			Object[] columnName = {"MEASURE SUMMARY DEF ID*", "MEASURE CODE*", "REPORT TYPE", "PRODUCT LINE", "AGG TYPE", "GRID NUM", "ROW1 HEADER", "ROW2 HEADER", "ROW3 HEADER", "ROW1", "ROW2", "ROW3", "ROW1 SORT", "ROW2 SORT", "ROW3 SORT", "COLUMN1", "COLUMN2", "COLUMN3", "COLUMN1 SORT", "COLUMN2 SORT", "COLUMN3 SORT", "ELEMENT ID", "DISPLAY TYPE", "CODE", "CREAT TMSTMP*","CREAT USER*", "UPDT TMSTMP", "UPDT USER", "MEASURE YEAR"};
			Object[] columnPojo = {"measureSummaryDefId", "measureId", "reportType", "productLine", "aggType", "gridNum", "row1Header", "row2Header" , "row3Header", "row1", "row2", "row3", "row1Sort", "row2Sort", "row3Sort", "column1", "column2", "column3", "column1Sort", "column2Sort", "column3Sort" ,"elementId" ,"displayType" ,"code" ,"creatTmstmp", "createUser", "updtTmstmp", "updtUser", "measureYear"};
			Object[] columnShow = {"ABBREV","MEASURE ID", "REPORT TYPE","PRODUCT LINE","AGGREGATE", "GRID NUM", "ROW1 HEADER", "ROW2 HEADER", "ROW3 HEADER", "ROW1", "ROW2", "ROW3", "ROW1 SORT", "ROW2 SORT", "ROW3 SORT","COLUMN2", "COLUMN3", "COLUMN1 SORT", "COLUMN2 SORT", "COLUMN3 SORT", "ELEMENT ID", "DISPLAY TYPE", "CODE","MEASURE YEAR"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		
		else if(tableName.equals("RUN RESULTS DEF"))
		{
			selectedTable = runResultsDefRepository.getRunResultsDefTable();
			selectedFullTable = runResultsDefRepository.getRunResultsDefFullTable();
			Object[] columnName = {"RUN RESULTS DEF ID", "MEASURE ID", "NUMERATOR ID", "HASHYBRID", "USEINOUTLIERREPORT", "ADMIN RATE", "ADMIN NUM HITS", "ADMIN DENOM HITS", "HYBRID RATE", "HYBRID NUM HITS", "HYBRID DENOM HITS", "HYBRID ADMIN HITS", "HYBRID MED HITS", "HYB ADMIN NUMERATOR", "HYB ADMIN RATE", "RATE DATA TYPE", "PRODUCT LINE", "RATE TYPE", "CREAT TMSTMP", "CREAT USER", "UPDT TMSTMP", "UPDT USER", "SUPPLMNTL NUMERATOR", "EXCLUSION CNT", "REQUIRED ADMIN EXCLUSION CNT", "REQUIRED HYBRID EXCLUSION CNT", "OPTIONAL ADMIN EXCLUSION CNT", "OPTIONAL HYBRID EXCLUSION CNT","MEASURE YEAR"};
			Object[] columnPojo = {"runResultsDefId", "measureId", "numeratorId", "hasHybrid", "useInOutlierReport", "adminRate","adminNumHits", "adminDenomHits", "hybridRate", "hybridNumHits", "hybridDenomHits", "hybridAdminHits", "hybridMedHits", "hybAdminNumerator", "hybAdminRate", "rateDataType", "productLine", "rateType", "creatTmstmp", "creatUser", "updtTmstmp", "updtUser", "supplmntlNumerator", "exclusionCnt", "requiredAdminExclusionCnt", "requiredHybridExclusionCnt", "optionalAdminExclusionCnt", "optionalHybridExclusionCnt", "measureYear"};
			Object[] columnShow = {"runResultsDefId", "measureId", "numeratorId", "hasHybrid", "useInOutlierReport", "adminRate","adminNumHits", "adminDenomHits", "hybridRate", "hybridNumHits", "hybridDenomHits", "hybridAdminHits", "hybridMedHits", "hybAdminNumerator", "hybAdminRate", "rateDataType", "productLine", "rateType", "creatTmstmp", "creatUser", "updtTmstmp", "updtUser", "supplmntlNumerator", "exclusionCnt", "requiredAdminExclusionCnt", "requiredHybridExclusionCnt", "optionalAdminExclusionCnt", "optionalHybridExclusionCnt", "measureYear"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("HDE EXCLUSIONS XWALK"))
		{
			selectedTable = exclusionRepository.getExclusionTable();
			selectedFullTable = exclusionRepository.getExclusionFullTable();
			Object[] columnName = {"MEASURE NAME*", "NUMERATOR ID", "EXCLUSION TYPE"};
			Object[] columnPojo = {"measureName", "numeratorId", "exclusionType"};
			Object[] columnShow = {"measureName", "numeratorId", "exclusionType"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("HDE PLD MEASURE XWALK"))
		{
			selectedTable = pldRepository.getPldTable();
			selectedFullTable = pldRepository.getPldFullTable();
			Object[] columnName = {"MEASURE NAME", "MEASURE ID", "STRATIFICATION ID", "DENOMINATOR FLAG", "DENOMINATOR EXCLUSION FLAG", "DENOMINATOR EXCEPTION FLAG", "NUMERATOR FLAG", "NUMERATOR EXCLUSION FLAG", "FINAL FLAG", "PLD COLUMN NAME", "TYPE OF EXCLUSION"};
			Object[] columnPojo = {"measureName", "measureId", "stratificationId", "denominatorFlag", "denominatorExclusionFlag", "denominatorExceptionFlag", "numeratorFlag", "numeratorExclusionFlag", "finalFlag", "pldColumnName", "typeOfExclusion"};
			Object[] columnShow = {"measureName", "measureId", "stratificationId", "denominatorFlag", "denominatorExclusionFlag", "denominatorExceptionFlag", "numeratorFlag", "numeratorExclusionFlag", "finalFlag", "pldColumnName", "typeOfExclusion"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("NCQA IDSS XWALK"))
		{
			selectedTable = idssRepository.getIdssTable();
			selectedFullTable = idssRepository.getIdssFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "ELEMENT NAME", "RPT ELEMENT NAME", "REPORT TYPE", "MEASURE DESCR", "STRATIFICATION ID", "STRATIFICAITON DESC", "SOURCE TYPE", "ELEMENT TYPE", "ELEMENT NAME RISK", "ELEMENT NAME AGE", "ELEMENT NAME GENDER", "IS ACTIVE", "IS COMMERCIAL", "IS MEDICARE", "IS MEDICAID", "IS SNP", "ELEMENT DESCRIPTION", "RPT DECIMAL", "DATA PAYER ID", "AUDIT HEADER", "IS REPORTABLE", "CREATE DT", "CREATED BY", "IS MARKETPLACE", "AGG ELEMENT TYPE", "SUMMARY GROUP", "SUMMARY ELEMENT TYPE", "AGE", "GENDER", "RISK"};
			Object[] columnPojo = {"measurementYr", "measureName", "elementName", "rptElementName", "reportType", "measureDesc", "stratificationId", "stratificationDesc", "sourceType", "elementType", "elementNameRisk", "elementNameAge", "elementNameGender", "isActive", "isCommercial", "isMedicare", "isMedicaid", "isSnp", "elementDescr", "rptDecimal", "dataPayerId", "auditHeader", "isReportable", "createDt", "createdBy", "isMarketPlace", "aggElementType", "summaryGroup", "summaryElementType", "age", "gender", "risk"};
			Object[] columnShow = {"measurementYr", "measureName", "elementName", "rptElementName", "reportType", "measureDesc", "stratificationId", "stratificationDesc", "sourceType", "elementType", "elementNameRisk", "elementNameAge", "elementNameGender", "isActive", "isCommercial", "isMedicare", "isMedicaid", "isSnp", "elementDescr", "rptDecimal", "dataPayerId", "auditHeader", "isReportable", "createDt", "createdBy", "isMarketPlace", "aggElementType", "summaryGroup", "summaryElementType", "age", "gender", "risk"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
			
		}
		else if(tableName.equals("NCQA MEASURES"))
		{
			selectedTable = measureRepository.getMeasureTable();
			selectedFullTable = measureRepository.getMeasureFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "MEASURE DESCRIPTION", "IS ACTIVE", "HAS HYBRID", "IS COMMERCIAL", "IS MEDICAID", "IS MEDICARE", "IS SNP", "NUMERATOR COUNT", "RUN TYPE", "STORE TYPE", "IS STARS", "DOMAIN ID", "SUB-DOMAIN ID", "SOURCE TYPE", "CREATE DT", "CREATED BY", "IS REPORTABLE", "IS MARKETPLACE", "HYB MEDICAID", "HYB MEDICARE", "HYB MARKETPLACE", "HYB SNP", "HYB COMMERCIAL"};
			Object[] columnPojo = {"measurementYr", "measureName", "measureDescr", "isActive", "hasHybrid", "isCommercial", "isMedicaid", "isMedicare", "isSnp", "numeratorCount", "runType", "storeType", "isStars", "domainId", "subDomainId", "sourceType", "createDt", "createdBy", "isReportable", "isMarketPlace", "hybMedicaid", "hybMedicare", "hybMarketPlace", "hybSnp", "hybCommercial"};
			Object[] columnShow = {"measurementYr", "measureName", "measureDescr", "isActive", "hasHybrid", "isCommercial", "isMedicaid", "isMedicare", "isSnp", "numeratorCount", "runType", "storeType", "isStars", "domainId", "subDomainId", "sourceType", "createDt", "createdBy", "isReportable", "isMarketPlace", "hybMedicaid", "hybMedicare", "hybMarketPlace", "hybSnp", "hybCommercial"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("NCQA SAMPLE SIZE"))
		{
			selectedTable = sampleSizeRepository.getSampleSizeTable();
			selectedFullTable = sampleSizeRepository.getSampleSizeFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE DESCRIPTION", "MEASURE NAME", "MEDICAID", "COMMERCIAL", "MEDICARE", "PY RATE", "RAND", "IS ACTIVE", "NOTE", "CREATE DATE", "CREATED BY"};
			Object[] columnPojo = {"measurementYr", "measureDesc", "measureName", "medicaid", "commercial", "medicare", "pyRate", "rand", "isActive", "note", "createDt", "createdBy"};
			Object[] columnShow = {"measurementYr", "measureDesc", "measureName", "medicaid", "commercial", "medicare", "pyRate", "rand", "isActive", "note", "createDt", "createdBy"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("NCQA MEASURES TO VALUESETS"))
		{
			selectedTable = measureValueSetRepository.getMeasureValueSetTable();
			selectedFullTable = measureValueSetRepository.getMeasureValueSetFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "MEASURE DESCRIPTION", "VALUESET NAME", "VALUESET OID", "CREATE DATE", "CREATED BY", "STRATIFICATION ID"};
			Object[] columnPojo = {"measurementYr", "measureName", "measDesc", "valuesetName", "valuesetOid", "createDt", "createdBy", "stratificationId"};
			Object[] columnShow = {"measurementYr", "measureName", "measDesc", "valuesetName", "valuesetOid", "createDt", "createdBy", "stratificationId"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("HDE VENDOR EVENT XWALK"))
		{
			selectedTable = vendorEventRepository.getVendorEventTable();
			selectedFullTable = vendorEventRepository.getVendorEventFullTable();
			Object[] columnName = {"VENDOR KEY", "MEASURE NAME", "SUB MEASURE", "EVENT DESCRIPTION", "METRIC CODE", "CREATE DATE", "CREATED BY"};
			Object[] columnPojo = {"vendorKey", "measureName", "subMeasure", "eventDescr", "metricCode", "createDt", "createdBy"};
			Object[] columnShow = {"vendorKey", "measureName", "subMeasure", "eventDescr", "metricCode", "createDt", "createdBy"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("HDE VENDOR NUM XWALK"))
		{
			selectedTable = vendorNumRepository.getVendorNumTable();
			selectedFullTable = vendorNumRepository.getVendorNumFullTable();
			Object[] columnName = {"VENDOR KEY", "VENDOR ID", "MEASURE NAME", "STRATIFICATION ID", "CREATE DATE", "CREATED BY", "VENDOR SUB MEASURE"};
			Object[] columnPojo = {"vendorKey", "vendorId", "measureName", "stratificationId", "createDt", "createdBy", "vendorSubMeasure"};
			Object[] columnShow = {"vendorKey", "vendorId", "measureName", "stratificationId", "createDt", "createdBy", "vendorSubMeasure"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("HDE MRR EXCL RSLT CODE"))
		{
			selectedTable = hdeMrrExclRsltCodeRepository.getHdeMrrExclRsltCodeTable();
			selectedFullTable = hdeMrrExclRsltCodeRepository.getHdeMrrExclRsltCodeFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "STRATIFICATION ID", "CODE", "IS RESULT", "IS EXCLUSION", "IS VALID DATA ERROR", "IS MRR OPT EXCL", "IS MRR REQ EXCL", "IS CBP FALSE POSITIVE"};
			Object[] columnPojo = {"measYr", "measureName", "stratificationId", "code", "isResult", "isExclsion", "isValidDataErr", "isMrrOptExcl", "isMrrReqExcl", "isCbpFalsePositive"};
			Object[] columnShow = {"measYr", "measureName", "stratificationId", "code", "isResult", "isExclsion", "isValidDataErr", "isMrrOptExcl", "isMrrReqExcl", "isCbpFalsePositive"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("SAMP EM IDSS XWALK"))
		{
			selectedTable = sampEmIdssRepository.getSampEmIdssTable();
			selectedFullTable = sampEmIdssRepository.getSampEmIdssFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "SAMPLE IDSS ELEMENT", "CREATE DATE", "CREATED BY", "UPDATE DATE", "UPDATED BY"};
			Object[] columnPojo = {"measurementYr", "measureName", "sampIdssElement", "createDt", "createdBy", "updateDt", "updatedBy"};
			Object[] columnShow = {"measurementYr", "measureName", "sampIdssElement", "createDt", "createdBy", "updateDt", "updatedBy"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("NCQA NUMERATORS"))
		{
			selectedTable = numeratorRepository.getNumeratorTable();
			selectedFullTable = numeratorRepository.getNumeratorFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "STRATIFICATION ID", "RPT DESCRIPTION", "DESCRIPTION", "IS ACTIVE", "CREATE DATE", "CREATED BY", "IS REPORTABLE", "OHM DESCRIPTION"};
			Object[] columnPojo = {"rptDescr", "descr", "isActive", "createDt", "createdBy", "isReportable", "ohmDescr"};
			Object[] columnShow = {"rptDescr", "descr", "isActive", "createDt", "createdBy", "isReportable", "ohmDescr"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("HDE MEAS AUDIT CW"))
		{
			selectedTable = measAuditRepository.getMeasAuditTable();
			selectedFullTable = measAuditRepository.getMeasAuditFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "METRIC CODE", "OBJ VALUE TYPE", "IS CHASE", "IS CS REPORTABLE", "IS ACTIVE", "CREATE DATE", "CREATED BY", "UPDATE DATE", "UPDATED BY", "IS PH REPORTABLE"};
			Object[] columnPojo = {"objValueType", "isChase", "isCsReportable", "isActive", "createDt", "createdBy", "updateDt", "updatedBy", "isPhReportable"};
			Object[] columnShow = {"objValueType", "isChase", "isCsReportable", "isActive", "createDt", "createdBy", "updateDt", "updatedBy", "isPhReportable"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("OHM MEAS CODES"))
		{
			selectedTable = measCodesRepository.getMeasCodesTable();
			selectedFullTable = measCodesRepository.getMeasCodesFullTable();
			Object[] columnName = {"MEASUREMENT YEAR", "MEASURE NAME", "TYPE", "CODE", "DESCRIPTION", "IS ACTIVE", "CLIENT KEY", "CREATE DATE", "CREATED BY", "UPDATE DATE", "UPDATED BY"};
			Object[] columnPojo = {"descr", "isActive", "clientKey", "createDt", "createdBy", "updateDt", "updatedBy"};
			Object[] columnShow = {"descr", "isActive", "clientKey", "createDt", "createdBy", "updateDt", "updatedBy"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		else if(tableName.equals("NCQA HYB IDSS XWALK"))
		{
			selectedTable = hybIdssRepository.getHybIdssTable();
			selectedFullTable = hybIdssRepository.getHybIdssFullTable();
			Object[] columnName = {"HYB IDSS CW KEY", "MEASUREMENT YR", "MEASURE NAME", "NUMERATOR ID", "STRATIFICATION ID", "PRODUCT LINE", "IDSS ELEMENT", "HYB ELEMENT TYPE", "ELEMENT TYPE", "AGG LEVEL", "IS ACTIVE", "CREATE DT", "CREATED BY", "NO OF NUMERATORS"};
			Object[] columnPojo = {"hybIdssCwKey", "measurementYr", "measureName", "numeratorId", "stratificationId", "productLine", "idssElement", "hybElementType", "elementType", "aggLevel", "isActive", "createDt", "createdBy", "noOfNumerators"};
			Object[] columnShow = {"hybIdssCwKey", "measurementYr", "measureName", "numeratorId", "stratificationId", "productLine", "idssElement", "hybElementType", "elementType", "aggLevel", "isActive", "createDt", "createdBy", "noOfNumerators"};
			
			for(Object[] row : selectedFullTable)
				selectedTable.add(row);
			
			selectedTable.add(columnName);
			selectedTable.add(columnPojo);
			selectedTable.add(columnShow);
		}
		
		return selectedTable;
	}
	
	@Override
	public List<Object[]> getUsersCredentials() {
		return usersListRepository.getUsersCredentials();
	}
	
	@Override
	public String saveAudit(Audit audit) {		
		auditRepository.saveAndFlush(audit);
		return "";
	}
	
	@Override
	public String saveNewUser(Users userToAdd) {	
		usersListRepository.saveAndFlush(userToAdd);
		try {
			emailNotificationUtil.userLoginMail(userToAdd);
		}
		catch(MailException e) {
			LOG.error("Error while sending mail " + e);	
			}
		return "";
	}
	
	@Override
	public List<String> getProductLineDetails() {	
		return measureSummaryDefRepository.getProductLineDetails();
		
	}
	
	@Override
	public String saveOnAddOrEditMeasureInClaimTable(Claim measureRowToAddOrEdit) {	
		claimRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInRunResultsDefTable(RunResultsDef measureRowToAddOrEdit) {
		runResultsDefRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInDenominatorEadMetricDefTable(DenominatorEadMetricDef measureRowToAddOrEdit) {	
		denominatorEadMetricDefRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInExclusionTable(Exclusion measureRowToAddOrEdit) {	
		exclusionRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInIdssTable(Idss measureRowToAddOrEdit) {	
		idssRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInMeasureTable(Measure measureRowToAddOrEdit) {	
		measureRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInPldTable(Pld measureRowToAddOrEdit) {	
		pldRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}

	@Override
	public String saveOnAddOrEditMeasureInDashMeasureSummaryDefTable(DashMeasureSummaryDef measureRowToAddOrEdit) {
		dashMeasureSummaryDefRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}

	@Override
	public String saveOnAddOrEditMeasureInMeasureDetailDefAccTable(MeasureDetailDefAcc measureRowToAddOrEdit) {
		measureDetailDefAccRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}

	@Override
	public String saveOnAddOrEditMeasureInMeasureSummaryDefTable(MeasureSummaryDef measureRowToAddOrEdit) {
		measureSummaryDefRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInHdeMrrExclRsltCodeTable(HdeMrrExclRsltCode measureRowToAddOrEdit) {	
		hdeMrrExclRsltCodeRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInMeasureValueSetTable(MeasureValueSet measureRowToAddOrEdit) {	
		measureValueSetRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInSampEmIdssTable(SampEmIdss measureRowToAddOrEdit) {	
		sampEmIdssRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInSampleSizeTable(SampleSize measureRowToAddOrEdit) {	
		sampleSizeRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInVendorEventTable(VendorEvent measureRowToAddOrEdit) {	
		vendorEventRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInVendorNumTable(VendorNum measureRowToAddOrEdit) {	
		vendorNumRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInNumeratorTable(Numerator measureRowToAddOrEdit) {	
		numeratorRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInMeasAuditTable(MeasAudit measureRowToAddOrEdit) {	
		measAuditRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInMeasCodesTable(MeasCodes measureRowToAddOrEdit) {	
		measCodesRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
	
	@Override
	public String saveOnAddOrEditMeasureInHybIdssTable(HybIdss measureRowToAddOrEdit) {	
		hybIdssRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}

	@Override
	public List<Object[]> getAllMeasureFromDefFiles(Long measureYearForMeasureCode) {
		return measureMasterRepository.getAllMeasureFromDefFiles(measureYearForMeasureCode);
		
	}

	@Override
	public String saveOnAddOrEditMeasureInOhrMeasureTable(OhrMeasure measureRowToAddOrEdit) {
		ohrMeasureRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}

	@Override
	public String saveOnAddOrEditMeasureInOhrNumeratorTable(OhrNumerator measureRowToAddOrEdit) {
		ohrNumeratorRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}

	@Override
	public String saveOnAddOrEditMeasureInMeasureMasterTable(MeasureMaster measureRowToAddOrEdit) {
		measureMasterRepository.saveAndFlush(measureRowToAddOrEdit);
		return "";
	}
}
