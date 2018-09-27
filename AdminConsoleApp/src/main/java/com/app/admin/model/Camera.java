package com.app.admin.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "camera")
@Access(value = AccessType.FIELD)
public class Camera {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "type")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*
	 * @OneToMany(mappedBy = "camera") private List<History> histories;
	 * 
	 * 
	 * 
	 * public List<History> getHistories() { return histories; }
	 * 
	 * public void setHistories(List<History> histories) { this.histories =
	 * histories; }
	 */
	@Override
	public String toString() {
		return "Camera [id=" + id + ", name=" + name + ", location=" + location + ", type=" + type + "]";
	}

}
