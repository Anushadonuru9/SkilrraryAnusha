package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import Annatations.BaseClass;



public class AddUserTest extends genericUtilities.BaseClass{
	@Test
	public void addUserTest() {
		SoftAssert soft=new SoftAssert();
		home.clickUserTab();
		soft.assertTrue(User.getPageHeader().contains("User"));
		users.clickNewButton();
		soft.assertEquals(addUsers.getpageHeader(), "Add New User");
		Map<String,String>map=excel.readFromExcel("Add User");
		addUsers.setEmail(map.get("Email"));
		addUsers.setPassword(map.get("password"));
		addUsers.setfirstname(map.get("Firstname"));
		addUsers.setLastname(map.get("Lastname"));
		addUsers.setaddress(map.get("Address"));
		addUsers.setContactInfo(map.get("Contact Info"));
		addUsers.uploadPhoto(map.get("photo"));
		addUsers.clickSave();
		soft.assertEquals(User.getSuccessMessage(), "Success!");
		soft.assertAll();
	}

}
