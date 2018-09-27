package com.app.admin.model;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "unidentifiedperson")
public class UnIdentifiedPerson {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "picurl")
	private String picurl;

	@Column(name = "picname")
	private String picname;

	@Lob
	@Column(name = "pictemplate")
	private Byte[] pictemplate;

	@Column(name = "approve")
	private String approve;

	@Column(name = "purpose")
	private String purpose;

	@Column(name = "timestamp")
	private Timestamp timestamp;

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

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public Byte[] getPictemplate() {
		return pictemplate;
	}

	public void setPictemplate(Byte[] pictemplate) {
		this.pictemplate = pictemplate;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "UnIdentifiedPerson [id=" + id + ", name=" + name + ", picurl=" + picurl + ", pictemplate=" + pictemplate
				+ ", approve=" + approve + ", purpose=" + purpose + ", timestamp=" + timestamp + "]";
	}

}
