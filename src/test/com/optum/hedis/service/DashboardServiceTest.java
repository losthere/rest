package com.optum.hedis.service;


import com.optum.hedis.domain.Audit;
import com.optum.hedis.domain.Claim;
import com.optum.hedis.domain.Exclusion;
import com.optum.hedis.domain.Idss;
import com.optum.hedis.domain.Measure;
import com.optum.hedis.domain.Numerator;
import com.optum.hedis.domain.Users;
import com.optum.hedis.repository.AuditRepository;
import com.optum.hedis.repository.ClaimRepository;
import com.optum.hedis.repository.ExclusionRepository;
import com.optum.hedis.repository.IdssRepository;
import com.optum.hedis.repository.MeasureRepository;
import com.optum.hedis.repository.NumeratorRepository;
import com.optum.hedis.repository.PldRepository;
import com.optum.hedis.repository.TableListRepository;
import com.optum.hedis.repository.UsersListRepository;
import com.optum.hedis.service.impl.DashboardServiceImpl;
import com.optum.hedis.util.DataExportUtil;
import com.optum.hedis.util.EmailNotificationUtil;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mail.MailException;
import org.springframework.mock.web.MockHttpServletResponse;

public class DashboardServiceTest extends BaseServiceTest{

	@InjectMocks
	private DashboardServiceImpl dashboardServiceImpl;
	
	@Mock
	private AuditRepository auditRepository;
	
	@Mock
	private UsersListRepository usersListRepository;
	
	@Mock
	private MeasureRepository measureRepository;
	
	@Mock
	private TableListRepository tableListRepository;
	
	@Mock
	private ClaimRepository claimRepository;
	
	@Mock
	private ExclusionRepository exclusionRepository;
	
	@Mock
	private PldRepository pldRepository;
	
	@Mock
	private IdssRepository idssRepository;
	
	@Mock
	private NumeratorRepository numeratorRepository;
	
	@Mock
	private EmailNotificationUtil emailNotificationUtil;
	
	@Mock
	private DataExportUtil fileExportUtil;
	
	
	public DashboardServiceTest(){
		
	}
	
	@Test
	public void getAudit()
	{
		List<Object[]> objArr = new ArrayList<Object[]>();
		Object[] data = new Object[] { "SWATI", "12:12:12","ABA", "ADD MEASURE"};
		objArr.add(data);

		Mockito.when(auditRepository.getAudit()).thenReturn(objArr);
		List<Object[]> result = dashboardServiceImpl.getAudit();
		assertNotNull(result);
		assertTrue(result.size()>0);
	}
	
	@Test
	public void getUsersCredentials()
	{
		List<Object[]> objArr = new ArrayList<Object[]>();
		Object[] data = new Object[] { "SWATI@OPTUM.COM", "SWATI","SWATI", "DEVELOPER", 1};
		objArr.add(data);
		
		Mockito.when(usersListRepository.getUsersCredentials()).thenReturn(objArr);
		List<Object[]> result = dashboardServiceImpl.getUsersCredentials();
		assertNotNull(result);
		assertTrue(result.size()>0);
	}
	
	@Test
	public void getAllMeasures()
	{
		List<String> strArr = new ArrayList<String>();
		String data = "2017, ABA, NA, 1, 1, 1, 1, 1, 1, 1, NA, NA, 1, 1, 1, NA, 12/12/12, NA, 1, 1, 1, 1, 1, 1, 1";
		strArr.add(data);
		
		Mockito.when(measureRepository.getAllMeasures()).thenReturn(strArr);
		List<String> result = measureRepository.getAllMeasures();
		assertNotNull(result);
		assertTrue(result.size()>0);
	}
	
	@Test
	public void getAllXWalkTables()
	{
		List<String> strArr = new ArrayList<String>();
		String data = "NCQA NUMERATOR";
		strArr.add(data);
		
		Mockito.when(tableListRepository.getAllXWalkTables()).thenReturn(strArr);
		List<String> result = tableListRepository.getAllXWalkTables();
		assertNotNull(result);
		assertTrue(result.size()>0);
	}
	
	@Test
	public void getSelectedTable()
	{
		List<Object[]> objArrClaim = new ArrayList<Object[]>();
		Object[] dataClaim = new Object[] { "ABA", "NA","NA", "NA", "NA", 2017};
		objArrClaim.add(dataClaim);
		
		List<Object[]> objArrExclusion = new ArrayList<Object[]>();
		Object[] dataExclusion = new Object[] {"ABA", "NA","NA"};
		objArrExclusion.add(dataExclusion);
		
		List<Object[]> objArrPld = new ArrayList<Object[]>();
		Object[] dataPld = new Object[] { 2017, "ABA","NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", 1, 1, 1, 1, "NA", "NA", "NA", "NA", 1, "2017-09-07", "NA", 1, "NA", "NA", "NA", "NA", "NA", "NA"};
		objArrPld.add(dataPld);
		
		List<Object[]> objArrIdss = new ArrayList<Object[]>();
		Object[] dataIdss = new Object[] { "ABA","NA", "NA", 1, 1, 1, 1, 1, 1, "NA", "NA"};
		objArrIdss.add(dataIdss);
		
		List<Object[]> objArrMeasure = new ArrayList<Object[]>();
		Object[] dataMeasure =new Object[] { 2017, "ABA","NA", 1, 1, 1, 1, 1, 1, 1, "NA", "NA", 1, 1, 1, 1, "NA", "2017-09-07", "NA", 1,1, 1, 1, 1, 1, 1, 1};
		objArrMeasure.add(dataMeasure);
		
		List<Object[]> objArrNumerator = new ArrayList<Object[]>();
		Object[] dataNumerator = new Object[] { "ABA", "NA","NA", 1, "NA","NA", 1, "NA"};
		objArrNumerator.add(dataNumerator);
		
		Mockito.when(claimRepository.getClaimTable()).thenReturn(objArrClaim);
		Mockito.when(exclusionRepository.getExclusionTable()).thenReturn(objArrExclusion);
		Mockito.when(pldRepository.getPldTable()).thenReturn(objArrPld);
		Mockito.when(idssRepository.getIdssTable()).thenReturn(objArrIdss);
		Mockito.when(measureRepository.getMeasureTable()).thenReturn(objArrMeasure);
		Mockito.when(numeratorRepository.getNumeratorTable()).thenReturn(objArrNumerator);
		
		List<Object[]> resultClaim = dashboardServiceImpl.getSelectedTable("HDE CLAIM ID XWALK");
		List<Object[]> resultExclusion = dashboardServiceImpl.getSelectedTable("HDE EXCLUSIONS XWALK");
		List<Object[]> resultPld = dashboardServiceImpl.getSelectedTable("HDE PLD MEASURE XWALK");
		List<Object[]> resultIdss = dashboardServiceImpl.getSelectedTable("NCQA IDSS XWALK");
		List<Object[]> resultMeasure = dashboardServiceImpl.getSelectedTable("NCQA MEASURES");
		List<Object[]> resultNumerator = dashboardServiceImpl.getSelectedTable("NCQA NUMERATORS");
		
		assertNotNull(resultClaim);
		assertTrue(resultClaim.size()>0);
		
		assertNotNull(resultExclusion);
		assertTrue(resultExclusion.size()>0);
		
		assertNotNull(resultPld);
		assertTrue(resultPld.size()>0);
		
		assertNotNull(resultIdss);
		assertTrue(resultIdss.size()>0);
		
		assertNotNull(resultMeasure);
		assertTrue(resultMeasure.size()>0);
		
		assertNotNull(resultNumerator);
		assertTrue(resultNumerator.size()>0);
	}
	
	@Test
	public void deleteMeasure() throws Exception {
		
		Mockito.doNothing().when(claimRepository).deleteMeasure(anyString(),anyLong());
		Mockito.doNothing().when(exclusionRepository).deleteMeasure(anyString());
		Mockito.doNothing().when(pldRepository).deleteMeasure(anyString());
		Mockito.doNothing().when(idssRepository).deleteMeasure(anyString(),anyLong());
		Mockito.doNothing().when(measureRepository).deleteMeasure(anyString(),anyLong());
		String result = dashboardServiceImpl.deleteMeasure(anyString(), anyLong());		
		assertNotNull(result);
	}
	
	@Test
	public void fileExport()
	{
        MockHttpServletResponse response = Mockito.mock(MockHttpServletResponse.class);
        response = Mockito.spy(new MockHttpServletResponse());
		List<Object[]> objArrClaim = new ArrayList<Object[]>();
		Object[] dataClaim = new Object[] { "ABA", "NA","NA", "NA", "NA", 2017};
		objArrClaim.add(dataClaim);
		
		List<Object[]> objArrExclusion = new ArrayList<Object[]>();
		Object[] dataExclusion = new Object[] {"ABA", "NA","NA"};
		objArrExclusion.add(dataExclusion);
		
		List<Object[]> objArrPld = new ArrayList<Object[]>();
		Object[] dataPld = new Object[] { 2017, "ABA","NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA", 1, 1, 1, 1, "NA", "NA", "NA", "NA", 1, "2017-09-07", "NA", 1, "NA", "NA", "NA", "NA", "NA", "NA"};
		objArrPld.add(dataPld);
		
		List<Object[]> objArrIdss = new ArrayList<Object[]>();
		Object[] dataIdss = new Object[] { "ABA","NA", "NA", 1, 1, 1, 1, 1, 1, "NA", "NA"};
		objArrIdss.add(dataIdss);
		
		List<Object[]> objArrMeasure = new ArrayList<Object[]>();
		Object[] dataMeasure =new Object[] { 2017, "ABA","NA", 1, 1, 1, 1, 1, 1, 1, "NA", "NA", 1, 1, 1, 1, "NA", "2017-09-07", "NA", 1,1, 1, 1, 1, 1, 1, 1};
		objArrMeasure.add(dataMeasure);
		
		List<Object[]> objArrNumerator = new ArrayList<Object[]>();
		Object[] dataNumerator = new Object[] { "ABA", "NA","NA", 1, "NA","NA", 1, "NA"};
		objArrNumerator.add(dataNumerator);
		
		Mockito.when(claimRepository.getClaimTableForExport()).thenReturn(objArrClaim);
		Mockito.when(exclusionRepository.getExclusionTableForExport()).thenReturn(objArrExclusion);
		Mockito.when(pldRepository.getPldTableForExport()).thenReturn(objArrPld);
		Mockito.when(idssRepository.getIdssTableForExport()).thenReturn(objArrIdss);
		Mockito.when(measureRepository.getMeasureTableForExport()).thenReturn(objArrMeasure);
		Mockito.when(numeratorRepository.getNumeratorTable()).thenReturn(objArrNumerator);
		
		fileExportUtil.createWorkBookForExcelFile(objArrClaim,response);
		fileExportUtil.createWorkBookForExcelFile(objArrExclusion,response);
		fileExportUtil.createWorkBookForExcelFile(objArrPld,response);
		fileExportUtil.createWorkBookForExcelFile(objArrIdss,response);
		fileExportUtil.createWorkBookForExcelFile(objArrMeasure,response);
		fileExportUtil.createWorkBookForExcelFile(objArrNumerator,response);
		
		String resultClaim = dashboardServiceImpl.fileExport("HDE CLAIM ID XWALK",response);
		String resultExclusion = dashboardServiceImpl.fileExport("HDE EXCLUSIONS XWALK",response);
		String resultPld = dashboardServiceImpl.fileExport("HDE PLD MEASURE XWALK",response);
		String resultIdss = dashboardServiceImpl.fileExport("NCQA IDSS XWALK",response);
		String resultMeasure = dashboardServiceImpl.fileExport("NCQA MEASURES",response);
		String resultNumerator = dashboardServiceImpl.fileExport("NCQA NUMERATORS",response);
		
		assertNotNull(resultClaim);
		assertNotNull(resultExclusion);
		assertNotNull(resultPld);
		assertNotNull(resultIdss);
		assertNotNull(resultMeasure);
		assertNotNull(resultNumerator);
	}
	
	
	
	@Test
	public void copyMeasure() throws Exception {
		
		Mockito.doNothing().when(claimRepository).copyMeasure(anyLong(),anyLong());
		Mockito.doNothing().when(idssRepository).copyMeasure(anyLong(),anyLong());
		Mockito.doNothing().when(measureRepository).copyMeasure(anyLong(),anyLong());
		String result = dashboardServiceImpl.copyMeasure(anyLong(), anyLong());		
		assertNotNull(result);
	}
	
	@Test
	public void saveNewUser() throws Exception {
		Users userToAdd = new Users();
		Mockito.when(usersListRepository.saveAndFlush(userToAdd)).thenReturn(userToAdd);
		Mockito.doNothing().when(emailNotificationUtil).userLoginMail(userToAdd);

		String result = dashboardServiceImpl.saveNewUser(userToAdd);
		assertNotNull(result);
	}
	
	@Test
	public void saveAudit() throws Exception {
		Audit audit = new Audit();
		Mockito.when(auditRepository.saveAndFlush(audit)).thenReturn(audit);
		String result = dashboardServiceImpl.saveAudit(audit);
		assertNotNull(result);
	}
	
	@Test
	public void saveOnAddOrEditMeasureInClaimTable() throws Exception {
		
		Claim claim = new Claim();
		Mockito.when(claimRepository.saveAndFlush(claim)).thenReturn(claim);
		String result = dashboardServiceImpl.saveOnAddOrEditMeasureInClaimTable(claim);
		assertNotNull(result);
	}
	
	@Test
	public void saveOnAddOrEditMeasureInExclusionTable() throws Exception {
		
		Exclusion exclusion = new Exclusion();
		Mockito.when(exclusionRepository.saveAndFlush(exclusion)).thenReturn(exclusion);
		String result = dashboardServiceImpl.saveOnAddOrEditMeasureInExclusionTable(exclusion);
		assertNotNull(result);
	}
	
	@Test
	public void saveOnAddOrEditMeasureInIdssTable() throws Exception {
		Idss idss = new Idss();
		Mockito.when(idssRepository.saveAndFlush(idss)).thenReturn(idss);
		String result = dashboardServiceImpl.saveOnAddOrEditMeasureInIdssTable(idss);
		assertNotNull(result);
	}
	
	@Test
	public void saveOnAddOrEditMeasureInMeasureTable() throws Exception {
		
		Measure measure = new Measure();
		Mockito.when(measureRepository.saveAndFlush(measure)).thenReturn(measure);
		String result = dashboardServiceImpl.saveOnAddOrEditMeasureInMeasureTable(measure);
		assertNotNull(result);
	}
	
	@Test
	public void saveOnAddOrEditMeasureInNumeratorTable() throws Exception {
		Numerator numerator = new Numerator();
		Mockito.when(numeratorRepository.saveAndFlush(numerator)).thenReturn(numerator);
		String result = dashboardServiceImpl.saveOnAddOrEditMeasureInNumeratorTable(numerator);
		assertNotNull(result);
	}
}
