package testScripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;
//This test Likely fails
public class CreateUserTest extends BaseClass
{
	public void createUserTest()
	{
		SoftAssert soft= new SoftAssert();
	
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader(). contains("Users"));
	
		users.clickNewButton();
		//Thread.sleep(3000);
	
		soft.assertEquals(addUser.getPageHeader(), "Add New User");
	
		Map<String, String> map= excel.readFromExcel("Sheet1", "Add User");
		addUser.createNewUser(map.get("Email"),map.get("Password"),
				map.get("Firstname"),map.get("Lastname"),map.get("Address"),
				map.get("Contact Info"),map.get("Photo"));
		
		soft.assertTrue(users.getSuccessMessage().contains("Success"));
		
		if (course.getSuccessMessage().contains("Success"))

			excel.writeToExcel("Sheet1", "Add User", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Sheet1", "Add User", "Fail", IConstantPath.EXCEL_PATH);

		soft.assertAll();
}
	
}
