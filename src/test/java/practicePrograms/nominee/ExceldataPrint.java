package practicePrograms.nominee;

import com.genericLibraries.lims.ExcelFetching;
import com.genericLibraries.lims.Iconstant;

public class ExceldataPrint {
	public static void main(String[] args) throws Throwable {
		
		
		
		
		ExcelFetching eutil=new ExcelFetching();
		System.out.println(eutil.getDataFromExcelBasedTestId(Iconstant.excelpath, "Nominee","TC_01", "Name"));
		
		
	}
		
	
	
}
