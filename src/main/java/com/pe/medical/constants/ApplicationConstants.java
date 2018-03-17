package com.pe.medical.constants;

public class ApplicationConstants {
	
	//Viewability constants
	public static String PUBLICLY_VIEWALE = "PUBLIC";
	public static String PRIVATELY_VIEWABLE = "PRIVATE";
	
	//AccessCodes status constants
	public static String GENERATED = "Generated";
	public static String EXPIRED = "Expired";
	public static String USED = "Used";
	
	public static int ACCESS_CODE_TTL = 10*60*1000; //10 minutes in milliseconds;
}
