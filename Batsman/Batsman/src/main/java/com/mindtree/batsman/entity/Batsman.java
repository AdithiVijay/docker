package com.mindtree.batsman.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Batsman {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int batsmanId;
	private String batsmanName;
	private int runs;
	private int innings;
	private int totalOut;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Team team;
	@OneToOne(mappedBy = "batsman")
	private Statistic statistic;

	@Override
	public String toString() {
		return "Batsman [batsmanId=" + batsmanId + ", batsmanName=" + batsmanName + ", runs=" + runs + ", innings="
				+ innings + ", totalOut=" + totalOut + ", team=" + team + ", statistic=" + statistic + "]";
	}

	public Batsman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batsman(int batsmanId, String batsmanName, int runs, int innings, int totalOut, Team team,
			Statistic statistic) {
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Statistic getStatistic() {
		return statistic;
	}

	public void setStatistic(Statistic statistic) {
		this.statistic = statistic;
	}

	
}
