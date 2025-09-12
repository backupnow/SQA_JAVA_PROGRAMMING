package mobiles

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class MobileKeyword {
	@Keyword
	public static void preTest(String username, String password) {

		Mobile.startExistingApplication(GlobalVariable.App, FailureHandling.STOP_ON_FAILURE)

		Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		
		Mobile.waitForElementPresent(findTestObject('Mobile/Login Screens/EditText - Username'), 5)
		Mobile.setText(findTestObject('Mobile/Login Screens/EditText - Username'), username, 0)
		
		Mobile.waitForElementPresent(findTestObject('Mobile/Login Screens/EditText - Password'), 5)
		Mobile.setText(findTestObject('Mobile/Login Screens/EditText - Password'), password, 0)

		Mobile.tap(findTestObject('Mobile/Login Screens/TextView - Login'), 0)
	}

	@Keyword
	public static void closeTest() {
		Mobile.closeApplication()
	}
}















