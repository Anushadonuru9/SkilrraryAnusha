package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IconstantPath;

public class AddCourseTest extends BaseClass{
	@Test
	public void addCourseTest() {
		SoftAssert soft=new SoftAssert();
		home.clickCourseTab();
		home.clickCourseListLink();
		soft.assertTrue(courseList.getPageHeader().contains("Course List"));
	
		courseList.clickNewButton();
		soft.assertEquals(addCourse.getPageHeader(), "Add New Course");
		Map<String,String>map=excel.readFromExcel("Add Course");
		addCourse.setName(map.get("Name"));
		addCourse.selectCategory(web,map.get("category"));
		addCourse.setPrice(map.get("price"));
		addCourse.setDescription(map.get("Description"),web);
		addCourse.clickSave();
		soft.assertEquals(courseList.getSuccessMessage(), "Success!");
		
		courseList.deleteCourse(web,map.get("Name"));
		soft.assertEquals(courseList.getSuccessMessage(),"Success!");
		if(courseList.getSuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add Course","pass",IconstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("add Course","Fail",IconstantPath.EXCEL_PATH);
		soft.assertAll();
	}

}
