package com.mindtree.batsman.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.batsman.entity.Statistic;
import com.mindtree.batsman.entity.Team;

public class BatsmanDto {
	private int batsmanId;
	private String batsmanName;
	private int runs;
	private int innings;
	private int totalOut;

@JsonIgnoreProperties("batsman")
	private TeamDto team;
@JsonIgnoreProperties("batsman")
	private StatisticDto statistic;
public BatsmanDto() {
	super();
	// TODO Auto-generated constructor stub
}
public BatsmanDto(int batsmanId, String batsmanName, int runs, int innings, int totalOut, TeamDto team,
		StatisticDto statistic) {
	super();
	this.batsmanId = batsmanId;
	this.batsmanName = batsmanName;
	this.runs = runs;
	this.innings = innings;
	this.totalOut = totalOut;
	this.team = team;
	this.statistic = statistic;
}
public int getBatsmanId() {
	return batsmanId;
}
public void setBatsmanId(int batsmanId) {
	this.batsmanId = batsmanId;
}
public String getBatsmanName() {
	return batsmanName;
}
public void setBatsmanName(String batsmanName) {
	this.batsmanName = batsmanName;
}
public int getRuns() {
	return runs;
}
public void setRuns(int runs) {
	this.runs = runs;
}
public int getInnings() {
	return innings;
}
public void setInnings(int innings) {
	this.innings = innings;
}
public int getTotalOut() {
	return totalOut;
}
public void setTotalOut(int totalOut) {
	this.totalOut = totalOut;
}
public TeamDto getTeam() {
	return team;
}
public void setTeam(TeamDto team) {
	this.team = team;
}
public StatisticDto getStatistic() {
	return statistic;
}
public void setStatistic(StatisticDto statistic) {
	this.statistic = statistic;
}

}
