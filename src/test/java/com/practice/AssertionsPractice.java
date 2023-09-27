package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void sampleTest()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		sa.assertEquals(false, false);
		System.out.println("Step 2");
		sa.assertEquals(false, true);
		System.out.println("Step 3");
		sa.assertEquals(true, false);
		System.out.println("Step 4");
		sa.assertEquals(true, true);
		System.out.println("Step 5");
		Assert.assertEquals(false, false);
		System.out.println("Step 6");
		Assert.assertEquals(false, true);
		System.out.println("Step 7");
		Assert.assertEquals(true, false);
		System.out.println("Step 8");
		Assert.assertEquals(true, true);
		System.out.println("Step 9");
		sa.assertAll();
	}
}
