package com.app.admin.controller;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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

import com.app.admin.exception.BadHttpRequest;
import com.app.admin.model.User;
import com.app.admin.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository repository;

	@GetMapping("/users")
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@RequestMapping(path = "/id/{id}")
	public User findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(path = "/name/{user}")
	public User findByName(@PathVariable("user") String user) {
		return repository.findByName(user);
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
	public User create(@RequestBody User userObj) throws IOException {
//		return repository.save(user);
		try {
			User u = new User();
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
			if (userObj.getEmpid() != 0)
				u.setEmpid(userObj.getEmpid());
			if (userObj.getName() != null)
				u.setName(userObj.getName());
			if (userObj.getPhone() != null)
				u.setPhone(userObj.getPhone());
			if (userObj.getPicname() != null)
				u.setPicname(userObj.getPicname());
			if (userObj.getPictemplate() != null) {
				u.setPictemplate(userObj.getPictemplate());
			} else {
				if (userObj.getPicurl() != null) {
					Image image = null;
					File userObjImage = new File(userObj.getPicurl());
					image = ImageIO.read(userObjImage);
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					ImageIO.write((RenderedImage) image, "png", os);
					byte[] data = new byte[1024];
					InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
					u.setPictemplate(getByteForimage(inputStream));
				}
			}
			if (userObj.getPicurl() != null)
				u.setPicurl(userObj.getPicurl());
			repository.save(u);
			User user = repository.findByName(userObj.getName());
			return user;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
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

	private byte[] getByteForimage(InputStream is) throws IOException {
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
}
