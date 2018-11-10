package com.app.admin.validator;

import com.app.admin.interfaces.IMessageValidator;
import com.app.admin.request.CreateUserRequest;
import com.app.admin.request.GenericRequestType;
import com.app.admin.response.GenericResponse;

public class UserDataValidator implements IMessageValidator {

	
	@Override
	public GenericResponse validateMessage(GenericRequestType request) {

		GenericResponse response=new GenericResponse();
		
		String detailMessageOnFailure=null;
		boolean successFlag=true;
		
		
		switch(request.getMessageType()){
		   case "createUser":
			     System.out.println("VALIDATING CREATE USER REQUEST");
			     CreateUserRequest createUser=(CreateUserRequest) request;
					
				 detailMessageOnFailure=createUserValidator(createUser);
					
  				 if(detailMessageOnFailure!=null){
  					successFlag=false;
				 }

			   break;
		    
		   case "deleteUser":
			   System.out.println("VALIDATING DELETE USER");
			   break;
		
		  	default:
		  		System.out.println("WE ARE IN DEFAULT CASE");
		  		break;
		  	
		}
		
		/*if(request.getMessageType().equals("createUser")){
			
			CreateUserRequest createUser=(CreateUserRequest) request;
			
			detailMessageOnFailure=createUserValidator(createUser);
			
			if(detailMessageOnFailure!=null){
 				successMessage="failure";
			}
			
		}else{
			
			
		}*/
		//successFlag=true;
		//detailMessageOnFailure=null;
		
		response.setSuccessFlag(successFlag);
		response.setDetailMessageOnFailure(detailMessageOnFailure);
		return response;
	
	}
	
	
	
	private String createUserValidator(CreateUserRequest createUser){
		
		String detailMessageOnFailure=null;
		
		if (createUser.getDepartment() == null || createUser.getDepartment() == ""){
			
			detailMessageOnFailure="Department Cannot be NULL or EMPTY";
		}
			
		if (createUser.getDob() == null ){
			
			detailMessageOnFailure="DOB Cannot be NULL or EMPTY";
		}


		if (createUser.getEmail() == null ){
			
			detailMessageOnFailure="Email Cannot be NULL or EMPTY";
		}

		
		if (createUser.getGender() == null ){
			
			detailMessageOnFailure="Gender Cannot be NULL or EMPTY";
		}

		if (createUser.getMisc() == null ){
			
			detailMessageOnFailure="Misc Cannot be NULL or EMPTY";
		}
		
		

		if (createUser.getName() == null ){
			
			detailMessageOnFailure="Name Cannot be NULL or EMPTY";
		}

		if (createUser.getPhone() == null ){
			
			detailMessageOnFailure="Phone Cannot be NULL or EMPTY";
		}

		/*if (createUser.getPicname() == null ){
			
			detailMessageOnFailure="Picname Cannot be NULL or EMPTY";
		}

		if (createUser.getPictemplate() == null ){
			
			detailMessageOnFailure="Pictemplate Cannot be NULL or EMPTY";
		}
		
		if (createUser.getPicurl() != null){
			
			detailMessageOnFailure="PicUrl Cannot be NULL or EMPTY";
		}
		if (createUser.getEmpid() > 0 ){
			
			detailMessageOnFailure="EmpId Cannot be NULL or EMPTY";
		}	
*/		
		
		return detailMessageOnFailure;
				
		
	}

}
