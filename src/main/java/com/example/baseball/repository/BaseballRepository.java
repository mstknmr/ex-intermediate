package com.example.baseball.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.baseball.domain.Team;

/**
 * Baseballのリポジトリクラス.
 * 
 * @author knmrmst
 */
@Repository
public class BaseballRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Teamオブジェクトを生成するRowMapper
	 */
	final static private RowMapper<Team> TEAM_ROW_MAPPER = (rs,i)->{
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	/**
	 * チーム情報の主キー検索.
	 * <p>
	 * 引数としてIDを受け取り、一致するIDを持つチームがあれば、そのチーム情報を返す。
	 * 一致するチームがなかった場合はNULLを返す
	 * </p>
	 * 
	 * @param id　チームID 
	 * @return	一致するデータがあれば、一致したチームの情報を返す。
	 * 			なかった場合はNULL
	 */
	public Team load(Integer id) {
		System.out.println("BaseballRepositoryのload()が呼び出されました");
		String loadSql="SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		try {
			Team team = template.queryForObject(loadSql, param, TEAM_ROW_MAPPER);
			return team;
		} catch (DataAccessException e) {
			System.out.println("id:"+id+" のチームはありません");
			return null;			
		}
	}
	
	/**
	 * チーム情報の全件検索.
	 * <p>
	 * 全てのチーム情報を返す。
	 * </p>
	 * 
	 * @return チーム情報のリスト
	 */
	public List<Team> findAll(){
		String findAllSql="SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams";
		return template.query(findAllSql,TEAM_ROW_MAPPER);
	}
	
	
}
