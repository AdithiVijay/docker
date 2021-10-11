package com.mindtree.batsman.service;

import java.util.List;

import com.mindtree.batsman.dto.AverageDto;
import com.mindtree.batsman.dto.BatsmanDto;
import com.mindtree.batsman.dto.IncomeDto;
import com.mindtree.batsman.dto.StatisticDto;
import com.mindtree.batsman.exception.ServiceException;

public interface BatsmanInterface {
public AverageDto average(int batsmanId) throws ServiceException;
public IncomeDto income(int batsmanId) throws ServiceException;
public List<BatsmanDto> display(int teamId) throws ServiceException;
public AverageDto avg(int batsmanId);
}
