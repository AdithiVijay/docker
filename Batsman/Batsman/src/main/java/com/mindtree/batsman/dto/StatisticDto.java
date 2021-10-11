package com.mindtree.batsman.dto;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.batsman.entity.Batsman;

public class StatisticDto {
	private int statisticId;
	private String average;
	private double income;
@JsonIgnoreProperties("statistic")
	private BatsmanDto batsman;
public StatisticDto() {
	super();
	// TODO Auto-generated constructor stub
}
public StatisticDto(int statisticId, String average, double income, BatsmanDto batsman) {
	super();
	this.statisticId = statisticId;
	this.average = average;
	this.income = income;
	this.batsman = batsman;
}
public int getStatisticId() {
	return statisticId;
}
public void setStatisticId(int statisticId) {
	this.statisticId = statisticId;
}
public String getAverage() {
	return average;
}
public void setAverage(String average) {
	this.average = average;
}
public double getIncome() {
	return income;
}
public void setIncome(double income) {
	this.income = income;
}
public BatsmanDto getBatsman() {
	return batsman;
}
public void setBatsman(BatsmanDto batsman) {
	this.batsman = batsman;
}

}
