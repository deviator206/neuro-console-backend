package com.admin.enums;

public enum EnumConstants {



	FTPPROPERTYFILE("ftp.properties");
	
	
	
	private String constantType;  
	
	private EnumConstants(String keyName){
		this.constantType=keyName;
		
	}
	 public String getConstantType() {
		    return constantType;
	  }

}
