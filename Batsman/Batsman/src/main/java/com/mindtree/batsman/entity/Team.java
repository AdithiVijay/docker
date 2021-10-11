package com.mindtree.batsman.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	private String teamName;
	private double pricePerMatch;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Batsman> batsman;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int teamId, String teamName, double pricePerMatch, List<Batsman> batsman) {
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

	public List<Batsman> getBatsman() {
		return batsman;
	}

	public void setBatsman(List<Batsman> batsman) {
		this.batsman = batsman;
	}

}
