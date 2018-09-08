package com.optum.hedis.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 * This class is an Utility class used to create excel
 * file.Method will return an excel file format
 * object that has to be attached to the response output stream
 */

@Component
public class DataExportUtil {
	
	private static final int EXCEL_ROW_SIZE = 100;
	private static final Logger LOG = Logger.getLogger(DataExportUtil.class);
	
	
    /**
     * Method to construct xwalk table data in
     * HSSFWorkbook format to export the data into xls format
     * 
     * @param xwalkTableDataSet
     *            Master data to be included in the exported file format
     * @param response
     *            HTTP servlet response
     * 
     * @return Workbook object for excel export
     */
	
	public void createWorkBookForExcelFile(List<Object[]> xwalkTableDataSet, HttpServletResponse response) {
		
		try {
			SXSSFWorkbook wb = new SXSSFWorkbook(EXCEL_ROW_SIZE);
			Sheet xwalkTableDataSheet = wb.createSheet("Master Data");
			int j = 1;

			Font font = wb.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			CellStyle cellStyle = wb.createCellStyle();
			cellStyle.setFont(font);

			/**
			 * Set data
			 */
			for (Object[] xwalkTableData : xwalkTableDataSet) {

				Row xwalkTableDataRow = xwalkTableDataSheet.createRow(j);
				for (int k = 0; k < xwalkTableData.length; k++) {

					Cell xwalkTableDataCell = xwalkTableDataRow.createCell(k);
					if (xwalkTableData[k] instanceof BigDecimal ) {
						xwalkTableDataCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						xwalkTableDataCell.setCellValue(new Double(xwalkTableData[k].toString()));
					} else if (xwalkTableData[k] instanceof Timestamp) {
						xwalkTableDataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
						xwalkTableDataCell.setCellValue(convertDateToSpecifiedFormat(xwalkTableData[k].toString(), "MM/dd/yyyy"));
					} else {
						xwalkTableDataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
						xwalkTableDataCell.setCellValue(xwalkTableData[k] != null ? xwalkTableData[k].toString() : StringUtils.EMPTY);
					}
				}
				j++;
			}
			wb.write(response.getOutputStream());
		} catch (IOException e) {
			LOG.error("Error while exporting xwalk table data to xls : " + e);
		}
	}
	
	private static String convertDateToSpecifiedFormat(String dateToBeFormatted, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
				date = sdf.parse(dateToBeFormatted);
			} 
		catch (ParseException e) {
			LOG.error("Error while converting Date to " + format + " format : " + e);
		}
		return new SimpleDateFormat(format).format(date);
	}
		
}
