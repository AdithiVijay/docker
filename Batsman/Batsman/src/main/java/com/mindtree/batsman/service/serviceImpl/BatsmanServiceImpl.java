package com.mindtree.batsman.service.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.batsman.dto.AverageDto;
import com.mindtree.batsman.dto.BatsmanDto;
import com.mindtree.batsman.dto.IncomeDto;
import com.mindtree.batsman.dto.StatisticDto;
import com.mindtree.batsman.entity.Batsman;
import com.mindtree.batsman.entity.Statistic;
import com.mindtree.batsman.entity.Team;
import com.mindtree.batsman.exception.BatsmanNotFoundException;
import com.mindtree.batsman.exception.DuplicatEntry;
import com.mindtree.batsman.exception.ServiceException;
import com.mindtree.batsman.exception.TeamNotPresentException;
import com.mindtree.batsman.repository.BatsmanRepository;
import com.mindtree.batsman.repository.StatisticRepository;
import com.mindtree.batsman.repository.TeamRepository;
import com.mindtree.batsman.service.BatsmanInterface;

@Service
public class BatsmanServiceImpl implements BatsmanInterface {
	@Autowired
	BatsmanRepository batsmanrepo;
	@Autowired
	StatisticRepository staticrepo;
	@Autowired
	TeamRepository teamrepo;
	private ModelMapper mapper = new ModelMapper();

	@Override
	public AverageDto average(int batsmanId) throws ServiceException {
		if (!batsmanrepo.existsById(batsmanId)) {
			throw new BatsmanNotFoundException("batsman not present");
		}
		List<Statistic> stats = staticrepo.findAll();
		for (Statistic statistic : stats) {
			if (statistic.getBatsman().getBatsmanId() == batsmanId) {
				throw new DuplicatEntry("duplicate entry");
			}
		}
		double average = 0.0;
		Statistic statistic = new Statistic();

		AverageDto average1 = new AverageDto();
		Batsman batsman = batsmanrepo.findById(batsmanId).get();
		int runs = batsman.getRuns();
		System.out.println(runs);
		int innings = batsman.getInnings();
		int totalout = batsman.getTotalOut();
		average = (runs) / ((innings) - (totalout));
		System.out.println(average);
		average1.setTeamName(batsman.getTeam().getTeamName());
		average1.setBatsmanName(batsman.getBatsmanName());
		average1.setAverage(average);
		statistic.setAverage(average);
		batsman.setStatistic(statistic);
		statistic.setBatsman(batsman);
		statistic = staticrepo.save(statistic);
		return average1;
	}

	@Override
	public IncomeDto income(int batsmanId) throws ServiceException {
		if (!batsmanrepo.existsById(batsmanId)) {
			throw new BatsmanNotFoundException("batsman not present");
		}

		IncomeDto income = new IncomeDto();
		Batsman batsman = batsmanrepo.findById(batsmanId).get();
		int id = batsman.getStatistic().getStatisticId();
		Statistic statistic = staticrepo.findById(id).get();
		Team team = batsman.getTeam();
		double price = team.getPricePerMatch();
		int innings = batsman.getInnings();

		double income1 = (price * innings);
		income.setBatsmanName(batsman.getBatsmanName());
		income.setTeamName(batsman.getTeam().getTeamName());
		income.setIncome(income1);
		if (statistic.getBatsman().getBatsmanId() == batsmanId) {
			batsman.setStatistic(statistic);
			statistic.setBatsman(batsman);
			statistic.setIncome(income1);
			statistic = staticrepo.save(statistic);
		}
		return income;
	}

	@Override
	public List<BatsmanDto> display(int teamId) throws ServiceException {
		if (!teamrepo.existsById(teamId)) {
			throw new TeamNotPresentException("team not found");
		}
		Team team = teamrepo.findById(teamId).get();
		List<Batsman> batsman = team.getBatsman();
		System.out.println(batsman);
		Comparator<Batsman> descPrice = (Batsman b1,
				Batsman b2) -> (int) (b2.getStatistic().getAverage() - b1.getStatistic().getAverage());
		Collections.sort(batsman, descPrice);
		System.out.println(batsman);
		List<BatsmanDto> batsmandto = batsman.stream().map(i -> mapper.map(i, BatsmanDto.class))
				.collect(Collectors.toList());
		return batsmandto;
	}

	@Override
	public AverageDto avg(int batsmanId) {
		AverageDto avg = new AverageDto();
		Batsman batsman = batsmanrepo.findById(batsmanId).get();
		double batsmanAverage = (batsman.getRuns()) / (batsman.getInnings() - batsman.getTotalOut());
		Statistic stats = batsman.getStatistic();
		batsman.setStatistic(stats);
		stats.setAverage(batsmanAverage);
		stats = staticrepo.save(stats);
		avg.setTeamName(batsman.getTeam().getTeamName());
		avg.setBatsmanName(batsman.getBatsmanName());
		avg.setAverage(batsmanAverage);
		return avg;
	}

}
