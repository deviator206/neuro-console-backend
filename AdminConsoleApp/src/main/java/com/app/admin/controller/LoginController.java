package com.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.admin.interfaces.IMessageValidator;
import com.app.admin.model.LoginDetails;
import com.app.admin.repository.LoginDetailsRepository;
import com.app.admin.request.LoginRequest;
import com.app.admin.response.GenericResponse;
import com.app.admin.response.LoginResponse;
import com.app.admin.validator.LoginDataValidator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginDetailsRepository repository;

	/*@GetMapping("/logindetails")
	public Iterable<LoginDetails> findAll() {
		return repository.findAll();
	}
	
	@RequestMapping(path = "/id/{id}")
	public LoginDetails findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(path = "/username/{username}")
	public LoginDetails findByName(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}

	@RequestMapping(value="/nameandrole")
	public LoginDetails findByNameAndRole(@Param("username") String username, @Param("role") String role) {
		return repository.findByUsernameAndRole(username, role);
	}

	@PostMapping(path = "/create")
	public LoginDetails create(@RequestBody LoginDetails loginDetails) {
		repository.save(loginDetails);
		System.out.println("CRETAE LOGIN USER ");
		return  repository.findByUsername(loginDetails.getUsername());
	}
*/	
	@PostMapping(consumes = "application/json")
	public LoginResponse findByNameAndPassword(@RequestBody LoginRequest loginRequest) {
		loginRequest.setMessageType("login");
		LoginResponse loginResponse=new LoginResponse();
		IMessageValidator loginDataValidator=new LoginDataValidator();
		GenericResponse genericResponse=loginDataValidator.validateMessage(loginRequest);
		boolean successFlag=true;
		if(genericResponse.isSuccessFlag()){
		
			LoginDetails loginData=repository.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
		
			if(loginData!=null ){
				loginResponse.setSuccessFlag(successFlag);
				loginResponse.setLoginData(loginData);
				System.out.println("LOGIN SUCCESSFUL"+loginData.getUsername());
			}else{
				loginResponse.setSuccessFlag(false);
				loginResponse.setDetailMessageOnFailure("Please check credentials");
				System.out.println("USER WITH PASSWORD NOT FOUND");
			}
		}else{
			loginResponse.setSuccessFlag(genericResponse.isSuccessFlag());
			loginResponse.setDetailMessageOnFailure(genericResponse.getDetailMessageOnFailure());
			System.out.println("LOGIN VALIDATION FAILED");
		}
		System.out.println(" LOGIN :");
		return  loginResponse;
	}
	

	/*@DeleteMapping(path = "/delete/id/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return "Deleted id = " + id + " Successfully";
	}

	@DeleteMapping(path = "/delete/username/{username}")
	public String deleteByName(@PathVariable("username") String username) {
		repository.delete(repository.findByUsername(username));
		return "Deleted username = " + username + " Successfully";
	}

	@PutMapping(path = "/update/username/{username}")
	public LoginDetails update(@PathVariable("username") String username, @RequestBody LoginDetails loginDetails)
			throws BadHttpRequest {
		LoginDetails login = repository.findByUsername(username);
		if (login != null) {
			if (loginDetails.getPassword() != null)
				login.setPassword(loginDetails.getPassword());
			if (loginDetails.getRole() != null)
				login.setRole(loginDetails.getRole());
			return repository.save(login);
		} else {
			return login;
		}
	}
*/
}
