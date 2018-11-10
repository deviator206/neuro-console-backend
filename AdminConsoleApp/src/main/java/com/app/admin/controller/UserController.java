package com.app.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.enums.EnumConstants;
import com.app.admin.exception.BadHttpRequest;
import com.app.admin.interfaces.IMessageValidator;
import com.app.admin.model.User;
import com.app.admin.repository.UnIdentifiedPersonRepository;
import com.app.admin.repository.UserRepository;
import com.app.admin.request.CreateUserRequest;
import com.app.admin.response.CreateUserRespose;
import com.app.admin.response.GenericResponse;
import com.app.admin.response.ListOfUsersResponse;
//import com.app.admin.request.UserRequest;
import com.app.admin.validator.UserDataValidator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private UnIdentifiedPersonRepository unIdentifiedPersonRepository;
	
	
	@GetMapping("/users")
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@RequestMapping(path = "/id/{id}")
	public ListOfUsersResponse findById(@PathVariable("id") int id) {
		ListOfUsersResponse listOfUsersResponse=new ListOfUsersResponse();
		boolean successFlag=true;
		try{
			List<User> listOfUsers=new ArrayList<User>() ;
			listOfUsers=repository.findByIdIn(id);
			listOfUsersResponse.setListOfUsers(listOfUsers);
		}catch(Exception ex){
			successFlag=false;
			listOfUsersResponse.setDetailMessageOnFailure(ex.getMessage());
			ex.printStackTrace();
		}
		
		listOfUsersResponse.setSuccessFlag(successFlag);
		return listOfUsersResponse;
		
	}

	@RequestMapping(path = "/name/{user}")
	public ListOfUsersResponse findByName(@PathVariable("user") String user) {
		ListOfUsersResponse listOfUsersResponse=new ListOfUsersResponse();
		boolean successFlag=true;
		try{
			List<User> listOfUsers=new ArrayList<User>() ;
			listOfUsers=repository.findByNameContaining(user);
			System.out.println("WE GET LIST OF USERS BY NAME");
			listOfUsersResponse.setListOfUsers(listOfUsers);
		}catch(Exception ex){
			successFlag=false;
			listOfUsersResponse.setDetailMessageOnFailure(ex.getMessage());
			ex.printStackTrace();
		}
		listOfUsersResponse.setSuccessFlag(successFlag);
		return listOfUsersResponse;
	}

	@RequestMapping(path = "/phone/{phone}")
	public User findByPhone(@PathVariable("phone") String phone) {
		return repository.findByPhone(phone);
	}

	@RequestMapping(path = "/email/{email}")
	public User findByEmail(@PathVariable("email") String email) {
		return repository.findByEmail(email);
	}

	@PostMapping(consumes = "application/json")
	public CreateUserRespose create(@RequestBody CreateUserRequest createUserObj)  {
		CreateUserRespose userRespose=new CreateUserRespose();
		boolean successFlag = true;
		createUserObj.setMessageType("createUser");
		try {
			IMessageValidator userValidator=new UserDataValidator();
			GenericResponse genericResponse=userValidator.validateMessage(createUserObj);
			
			System.out.println("validation message for failure: "+genericResponse.getDetailMessageOnFailure());
			if(genericResponse.isSuccessFlag()){
				User userObj=createUserFromRequest(createUserObj);
				
				String propPath=readKeyValueFromPropertyFile(EnumConstants.FTPPROPERTYFILE.getConstantType(), "imagePath");
				
				String imagePath=createImage(createUserObj.getImgBase64(),propPath,userObj.getName()+""+userObj.getPhone());
				
				userObj.setPicurl(imagePath);
				
				User user = repository.save(userObj);
				userRespose.setUserObj(user);
					
			}else{
				successFlag=genericResponse.isSuccessFlag();
				userRespose.setDetailMessageOnFailure(genericResponse.getDetailMessageOnFailure());
			}
			//TODO: TESTING PURPOSE
			//broadCastMessage();
			
		} catch (Exception e) {
			userRespose.setDetailMessageOnFailure(e.getMessage());
			successFlag = false;
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		userRespose.setSuccessFlag(successFlag);
		return userRespose;
	}

	@DeleteMapping(path = "/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return "Deleted id = " + id + " Successfully";
	}

	@PutMapping(path = "/update/{user}")
	public User update(@PathVariable("user") String user, @RequestBody User userObj)
			throws BadHttpRequest, IOException {
		User u = repository.findByName(user);
		if (userObj.getDepartment() != null)
			u.setDepartment(userObj.getDepartment());
		if (userObj.getDob() != null)
			u.setDob(userObj.getDob());
		if (userObj.getEmail() != null)
			u.setEmail(userObj.getEmail());
		if (userObj.getGender() != null)
			u.setGender(userObj.getGender());
		if (userObj.getMisc() != null)
			u.setMisc(userObj.getMisc());
		if (userObj.getName() != null)
			u.setName(userObj.getName());
		if (userObj.getEmpid() != 0)
			u.setEmpid(userObj.getEmpid());
		if (userObj.getPhone() != null)
			u.setPhone(userObj.getPhone());
		if (userObj.getPicname() != null)
			u.setPicname(userObj.getPicname());
		if (userObj.getPictemplate() != null)
			u.setPictemplate(userObj.getPictemplate());
		if (userObj.getPicurl() != null)
			u.setPicurl(userObj.getPicurl());
		return repository.save(u);
	}

	
	private User createUserFromRequest(CreateUserRequest userObj) throws IOException{
		
		User u = new User();
			u.setDepartment(userObj.getDepartment());
			u.setDob(userObj.getDob());
			u.setEmail(userObj.getEmail());
			u.setGender(userObj.getGender());
			u.setMisc(userObj.getMisc());
			//u.setEmpid(userObj.getEmpid());
			u.setName(userObj.getName());
			u.setPhone(userObj.getPhone());
			//u.setPicname(userObj.getPicname());
			
			
		/*if (userObj.getPictemplate() != null) {
			u.setPictemplate(userObj.getPictemplate());
		} else {
			if (userObj.getPicurl() != null) {
				Image image = null;
				File userObjImage = new File(userObj.getPicurl());//USERS/Ketan/Desktop/visa.png
				image = ImageIO.read(userObjImage);
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				ImageIO.write((RenderedImage) image, "png", os);
				byte[] data = new byte[1024];
				InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
				u.setPictemplate(getByteForimage(inputStream));
			}
		}*/
		
			//u.setPicurl(userObj.getPicurl());
			
			return u;
	}
	
	/*private byte[] getByteForimage(InputStream is) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[1024];
		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		buffer.flush();
		byte[] byteArray = buffer.toByteArray();
		return byteArray;
	}
	
	
	private void broadCastMessage(){
		
		BroadcastMessageResponse broadcastMessage=new BroadcastMessageResponse();
		
		broadcastMessage.setSuccessFlag(true);
		broadcastMessage.setUnIdentifiedPerson(null);
		
		//broadcastMessage.setUnIdentifiedPerson(unIdentifiedPersonRepository.findAll());
		BroadCastMessageHelper helper=new BroadCastMessageHelper();
			
			helper.sendMessageToAll(broadcastMessage);
	}
	
	private void  createUnIdentifiedPersonRepository(User user){
		System.out.println("CREATING UNIDENTIFIED PERSON");
		UnIdentifiedPerson unIdentifiedPerson=new UnIdentifiedPerson(user.getId(),user.getName(),user.getPicurl());
		Byte picByte=new Byte("test");
		long time=21314144l;
		Timestamp timeStamp=new Timestamp(time);
		unIdentifiedPerson.setTimestamp(timeStamp);
		unIdentifiedPerson.setApprove("approve");
		unIdentifiedPerson.setPurpose("purpose");
		unIdentifiedPerson.setPictemplate(null);
		unIdentifiedPerson.setPicname("picname");
		unIdentifiedPersonRepository.save(unIdentifiedPerson);
		
		
	}*/
	
	
	private String createImage(String base64String,String path,String fileName){
		//String base64String = "data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAAHkAAAB5C...";
		//String path="/Volumes/DATA/WORKSAPCE/NEURO_WORKSPACE/";
        String[] strings = base64String.split(",");
        String extension,imageCreatedPath=null;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }
        //convert base64 string to binary data
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        String fullpath = path+""+fileName+"."+ extension;  //"C:\\Users\\Ene\\Desktop\\test_image." + extension;
        System.out.println("PATH::"+fullpath);
        File file = new File(fullpath);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
            imageCreatedPath=file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }///Users/Ketan/Desktop
		System.out.println("CREATED IMAGE");
		return imageCreatedPath;
	}
	

	
	private String readKeyValueFromPropertyFile(String propertyFileName,String key ){
		
		String keyValue=null;
		try {
			Properties dbprops = new Properties(); 
			InputStream inputStream=getClass().getClassLoader().getResourceAsStream(propertyFileName);
			dbprops.load(inputStream);
			
			keyValue = dbprops.get(key).toString();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return keyValue;
	}
	
	
	
}
