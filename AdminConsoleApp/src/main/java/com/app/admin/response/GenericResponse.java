package com.app.admin.response;

public class GenericResponse {

	private boolean successFlag;
	private String detailMessageOnFailure;
	
	
	public boolean isSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}
	public String getDetailMessageOnFailure() {
		return detailMessageOnFailure;
	}
	public void setDetailMessageOnFailure(String detailMessageOnFailure) {
		this.detailMessageOnFailure = detailMessageOnFailure;
	}
	
	
}
