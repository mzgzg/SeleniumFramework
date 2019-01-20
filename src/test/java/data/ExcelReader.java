package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream inputStream = null;

	public FileInputStream getFileInputStram() {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.xlsx";
		File sourceFile = new File(filePath);
		try {
			inputStream = new FileInputStream(sourceFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error occured : " + e.getMessage());
			System.exit(0);
		}
		return inputStream;
	}

	public Object[][] getExcelData() throws IOException {
		inputStream = getFileInputStram();
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalNumberOfRows = sheet.getLastRowNum() + 1;
		int totalNumberOfColumns = 7;
		String[][] arrayOfExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
		for (int i = 0; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberOfColumns; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayOfExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayOfExcelData;
	}
}
