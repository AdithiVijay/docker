package com.mindtree.batsman.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.batsman.entity.Batsman;

public class TeamDto {
	private int teamId;
	private String teamName;
	private double pricePerMatch;
	@JsonIgnoreProperties("team")
	private List<BatsmanDto> batsman;
	public TeamDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamDto(int teamId, String teamName, double pricePerMatch, List<BatsmanDto> batsman) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.pricePerMatch = pricePerMatch;
		this.batsman = batsman;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getPricePerMatch() {
		return pricePerMatch;
	}
	public void setPricePerMatch(double pricePerMatch) {
		this.pricePerMatch = pricePerMatch;
	}
	public List<BatsmanDto> getBatsman() {
		return batsman;
	}
	public void setBatsman(List<BatsmanDto> batsman) {
		this.batsman = batsman;
	}
	
}
