package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IconstantPath;

public class AddCategoryTest extends BaseClass{
	@Test
	public void addCategoryTest() {
		SoftAssert soft=new SoftAssert();
		home.clickCourseTab();
		home.clickCourseListLink();
		soft.assertEquals(category.getPageHeader(), "category");
		category.clickNewButton();
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		Map<String,String>map=excel.readFromExcel("Add Category");
		addCategory.setName(map.get("Name"));
		
		addCategory.clickSave();
		soft.assertEquals(category.getSuccessMessage(), "Sucess!");
		
		category.deleteCategory(web,map.get("Name"));
		soft.assertEquals(category.getSuccessMessage(),"Success!");
		if(category.getSuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add category","pass",IconstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Category","Fail",IconstantPath.EXCEL_PATH);
		soft.assertAll();
			
		}
	}


