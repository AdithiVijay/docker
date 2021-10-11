package com.mindtree.batsman.dto;

public class IncomeDto {
	private String batsmanName;
	private String teamName;
	private double income;
	public IncomeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IncomeDto(String batsmanName, String teamName, double income) {
		super();
		this.batsmanName = batsmanName;
		this.teamName = teamName;
		this.income = income;
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
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
}
