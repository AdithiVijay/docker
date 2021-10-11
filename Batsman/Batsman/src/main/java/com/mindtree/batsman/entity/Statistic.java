package com.mindtree.batsman.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Statistic implements Comparable<Statistic>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statisticId;
	private double average;
	private double income;
	@OneToOne
	private Batsman batsman;

	public Statistic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Statistic(int statisticId, double average, double income, Batsman batsman) {
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

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public Batsman getBatsman() {
		return batsman;
	}

	public void setBatsman(Batsman batsman) {
		this.batsman = batsman;
	}

	@Override
	public int compareTo(Statistic s) {
		return (int) (s.getAverage()-this.getAverage());
	}

	
}
