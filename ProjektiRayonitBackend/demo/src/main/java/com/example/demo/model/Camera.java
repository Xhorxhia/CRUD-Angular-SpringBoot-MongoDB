package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Camera")
public class Camera {

	@Id
	private int id;
	private String name;
	private String model;
	private String resolution;
	private String ip;

	public Camera() {
	}

	public Camera(int id, String name, String model, String resolution, String ip) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.resolution = resolution;
		this.ip = ip;
	}

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "Camera Id:"+id+" Name:"+name+" Model:"+model+" Resolution:"+resolution+" Ip:"+ip;
	}

}
