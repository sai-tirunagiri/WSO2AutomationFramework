package com.quinnox.testautomation.service;

import com.quinnox.testautomation.dao.SoPoTestCode;



public class Sample {
	public static void main(String[] args) {
		SoPoTestCode soPoTestCode = new SoPoTestCode();
		
		String json = soPoTestCode.getHeaderTableDataForGivenHeaderID("293933575");
		System.out.println(json);
		
		System.out.println(json.contains("郑涛"));
		
	}
}