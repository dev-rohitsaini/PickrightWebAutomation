package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNG testNg = new TestNG();
		
		
		
		List<String> suite = new ArrayList<String>();
		
		suite.add("D:\\Pickright\\PickrightWebAutomation\\testng.xml");
		
		testNg.setTestSuites(suite);
		
		testNg.run();

	}

}
