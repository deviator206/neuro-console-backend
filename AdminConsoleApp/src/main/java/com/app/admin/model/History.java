package com.app.admin.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "cameratype")
	private String cameratype;
	
	@Column(name = "timein")
	private Timestamp timein;
	
	@Column(name = "timeout")
	private Timestamp timeout;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCameratype() {
		return cameratype;
	}

	public void setCameratype(String cameratype) {
		this.cameratype = cameratype;
	}

	public Timestamp getTimein() {
		return timein;
	}

	public void setTimein(Timestamp timein) {
		this.timein = timein;
	}

	public Timestamp getTimeout() {
		return timeout;
	}

	public void setTimeout(Timestamp timeout) {
		this.timeout = timeout;
	}

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="camera_type") private Camera camera;
	 * 
	 * 
	 * 
	 * public Camera getCamera() { return camera; } public void setCamera(Camera
	 * camera) { this.camera = camera; }
	 */
	@Override
	public String toString() {
		return "History [id=" + id + ", cameratype=" + cameratype + ", timein=" + timein + ", timeout=" + timeout + "]";
	}

}
