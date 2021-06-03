package com.application.marsapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsPhoto {

	private Long id;
	private int sol;
	private MarsCamera camera;
	@JsonProperty("img_src")
	private String imgSrc;
	@JsonProperty("earth_date")
	private String earthDate;
	private MarsRover rover;
	
	
	
	@Override
	public String toString() {
		return "MarsPhoto [id=" + id + ", sol=" + sol + ", camera=" + camera + ", imageSrc=" + imgSrc + ", earthdate="
				+ earthDate + ", rover=" + rover + "]";
	}

	public String getEarthDate() {
		return earthDate;
	}

	public void setEarthDate(String earthdate) {
		this.earthDate = earthdate;
	}

	public MarsRover getRover() {
		return rover;
	}

	public void setRover(MarsRover rover) {
		this.rover = rover;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSol() {
		return sol;
	}
	public void setSol(int sol) {
		this.sol = sol;
	}
	public MarsCamera getCamera() {
		return camera;
	}
	public void setCamera(MarsCamera camera) {
		this.camera = camera;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imageSrc) {
		this.imgSrc = imageSrc;
	}
	
	
	
}
