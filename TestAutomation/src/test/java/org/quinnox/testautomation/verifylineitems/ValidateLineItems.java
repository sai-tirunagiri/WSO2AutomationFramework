package org.quinnox.testautomation.verifylineitems;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.quinnox.testautomation.service.OrderImortService;

public class ValidateLineItems {
	OrderImortService orderImortService;
	@BeforeClass
	public void init(){
		orderImortService = new OrderImortService();
	}
	
	@Test
	public void comparisonOfLineItems(){
		//Step 1 : Get the compared result for line items
		boolean lineItemComparedResults = orderImortService.getOrderMappedValues();
		
		//Step 2 : validate the result
		//System.out.println(lineItemComparedResults);
		Assert.assertEquals(lineItemComparedResults,true,"No unit price found for the perticular order ID");
		//Assert.assertEquals(lineItemComparedResults, true,"");
	}
}
