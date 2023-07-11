package practicePrograms.nominee;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginWithDataProvider {
	
	public Object[][] readMultipleDataFromExcel(String path, String sheetname) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][]data = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	
	}
	
}
