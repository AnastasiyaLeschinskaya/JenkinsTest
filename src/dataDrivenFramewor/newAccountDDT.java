package dataDrivenFramewor;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith (value = Parameterized.class)
public class newAccountDDT {
	String name;
	String email;
	String phone;
	
	public newAccountDDT (String name, String email, String phone, String gender, 
			String test1, String test2, String test3, String test4, String test5){
		this.name = name;
		this.email = email;
		this.phone = phone;	
	}
	
	@Test
	public void newAccountTest(){
		System.out.print("name " + name + " " + email + " "+ phone);
	}
	
	@Parameters
	public static List<String[]> getData(){
		return csvFileReader.get("C:\\Users\\user\\Downloads\\UserAccounts.csv"); 
	}

}
