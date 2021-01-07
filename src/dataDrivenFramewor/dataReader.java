package dataDrivenFramewor;

import java.util.List;

public class dataReader {

	public static void main(String[] args) {
		//readCSV();
		readXLS();
	}
	
	public static void readCSV() {
		String fileName = "C:\\Users\\user\\Downloads\\UserAccounts.csv";
		List <String[]> records = csvFileReader.get(fileName);
			for (String[] record: records) {
				for (String field: record) {
					System.out.println(field);
				}
			}
	}
	
	public static void readXLS() {
		String fileName = "C:\\Users\\user\\Downloads\\UserLogin.xls";
		String[][] data = excelReader.get(fileName);
		for (String[] record : data) {
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}

}
