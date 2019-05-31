package com.example.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseball.domain.Team;
import com.example.baseball.repository.BaseballRepository;

/**
 * Baseballのサービスクラス.
 * 
 * @author knmrmst
 *
 */
@Service
@Transactional
public class BaseballService {
	@Autowired
	BaseballRepository baseballRepository;
	
	/**
	 * チーム情報の全件検索.
	 * 
	 * @return チーム情報のリスト
	 */
	public List<Team> showTeamList(){
		return baseballRepository.findAll();
	}
	
	/**
	 * チーム情報の主キー検索.
	 * 
	 * @param id チームID
	 * @return　チーム情報
	 */
	public Team showDetail(Integer id) {
		return baseballRepository.load(id);
	}
}
