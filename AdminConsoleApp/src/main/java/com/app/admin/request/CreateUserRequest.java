package com.app.admin.request;

import java.util.Date;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
public class CreateUserRequest extends GenericRequestType{
/*
 * department: "HR & IT"
dob: "12/23/2018"
email: "dev@gm.com"
empid: 6
gender: "male"

misc: "I dont know what to say"
name: "Sandeep"
phone: "902138123913"
picname: null
pictemplate: null
picurl: null

imgBase64: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAoAA
 */
//TODO: phone,name,imgBase64,email
	//private int id;

	private String name;

	private String gender;

	private Date dob;

	private String phone;

	private String email;

	//private int empid;

	private String department;

	private String misc;

	//private String picurl;
	
	//private String picname;

	//private byte[] pictemplate;

	private String imgBase64;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	
	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	
	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public byte[] getPictemplate() {
		return pictemplate;
	}

	public void setPictemplate(byte[] inputStream) {
		this.pictemplate = inputStream;
	}
	

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}
*/	
	

	public String getImgBase64() {
		return imgBase64;
	}

	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}


	@Override
	public String toString() {
		return "CreateUserRequest [name=" + name + ", gender=" + gender
				+ ", dob=" + dob + ", phone=" + phone + ", email=" + email
				+ ", department=" + department + ", misc=" + misc
				+ ", imgBase64=" + imgBase64 + "]";
	}
	
	
	
	/*

	String username;
	String password;
	String role;
	
	public UserRequest(){
		
	}

	public UserRequest(String userName, String password, String role) {
		super();
		this.username = userName;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
*/}
