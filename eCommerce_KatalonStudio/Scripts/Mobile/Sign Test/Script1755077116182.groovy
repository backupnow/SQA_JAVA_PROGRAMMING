import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'mobiles.MobileKeyword.preTest'(GlobalVariable.Username, GlobalVariable.Password)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

try {
    // Code that might throw an exception
    Mobile.verifyElementVisible(findTestObject('Mobile/Inventory Screen/TextView - Title'), 0)

    Mobile.verifyElementVisible(findTestObject('Mobile/Inventory Screen/TextView - Price'), 0)

    Mobile.verifyElementVisible(findTestObject('Mobile/Inventory Screen/TextView - Baju'), 0)

    Mobile.verifyElementText(findTestObject('Mobile/Inventory Screen/TextView - Baju'), '')
}
catch (Exception e) {
    println("Caught a general exception: $e.message")
} 
finally { 
    CustomKeywords.'mobiles.MobileKeyword.closeTest'()
}

