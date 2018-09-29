package com.app.admin.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "history")
@NamedQueries({
    @NamedQuery(
    		name = "History.findByMinTimeInWhereDateIs", query = "select min(h.timein) from History h where h.date =?1"
        ),
    @NamedQuery(name = "History.findByMaxTimeOutWhereDateIs", query = "select max(h.timeout) from History h where h.date =?1")
})
public class History {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "cameratype")
	private String cameratype;

	@Column(name = "name")
	private String name;

	

	@Column(name = "timein")
	private Timestamp timein;

	@Column(name = "timeout")
	private Timestamp timeout;

	@Column(name = "timestamp")
	private Timestamp date;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "History [id=" + id + ", cameratype=" + cameratype + ", name=" + name + ", timein=" + timein
				+ ", timeout=" + timeout + ", date=" + date + "]";
	}

}
