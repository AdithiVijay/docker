package com.mindtree.batsman.dto;

public class AverageDto {
private String batsmanName;
private String teamName;
private double average;
public AverageDto() {
	super();
	// TODO Auto-generated constructor stub
}
public AverageDto(String batsmanName, String teamName, double average) {
	super();
	this.batsmanName = batsmanName;
	this.teamName = teamName;
	this.average = average;
}
public String getBatsmanName() {
	return batsmanName;
}
public void setBatsmanName(String batsmanName) {
	this.batsmanName = batsmanName;
}
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
public double getAverage() {
	return average;
}
public void setAverage(double average) {
	this.average = average;
}


}
