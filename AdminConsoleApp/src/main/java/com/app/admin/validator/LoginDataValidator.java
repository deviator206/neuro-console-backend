package com.app.admin.validator;

import com.app.admin.interfaces.IMessageValidator;
import com.app.admin.request.GenericRequestType;
import com.app.admin.request.LoginRequest;
import com.app.admin.response.GenericResponse;

public class LoginDataValidator implements IMessageValidator{

	@Override
	public GenericResponse validateMessage(GenericRequestType request) {

		GenericResponse response=new GenericResponse();
		
		String detailMessageOnFailure=null;
		boolean successFlag=true;
		
		
		switch(request.getMessageType()){
		   case "login":
			     System.out.println("VALIDATING LOGIN USER REQUEST");
			     LoginRequest loginRequest=(LoginRequest) request;
					
				 detailMessageOnFailure=loginUserValidator(loginRequest);
					
  				 if(detailMessageOnFailure!=null){
  					successFlag=false;
				 }

			   break;
		   
		  	default:
		  		System.out.println("WE ARE IN DEFAULT CASE");
		  		break;
		  	
		}
		
		
		
		response.setSuccessFlag(successFlag);
		response.setDetailMessageOnFailure(detailMessageOnFailure);
		return response;
	
	}

	
	private String loginUserValidator(LoginRequest loginRequest){
		String detailMessageOnFailure=null;
		if(loginRequest.getUsername()!=null && 
		   loginRequest.getUsername().length()>0 &&
		   loginRequest.getPassword()!=null && 
		   loginRequest.getPassword().length()>0){
			
			detailMessageOnFailure=null;
		}else{
			detailMessageOnFailure=" USERNAME PASSWORD CANNOT BE NULL OR EMPTY";
		}
		
		return detailMessageOnFailure;
		
	}
}
