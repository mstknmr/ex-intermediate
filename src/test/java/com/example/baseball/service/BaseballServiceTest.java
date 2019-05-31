package com.example.baseball.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.baseball.domain.Team;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseballServiceTest {

	@Autowired
	BaseballService baseballService;
	
	@Test
	public void baseballServiceTest1() {
		Team team = baseballService.showDetail(1);
		System.out.println(team);
		assertThat("TC1:期待値と実際の結果が異なります", team.getTeamName(), is("読売ジャイアンツ"));
	}
	@Test
	public void baseballServiceTest2() {
		Team team = baseballService.showDetail(2);
		assertThat("TC2:期待値と実際の結果が異なります", team.getTeamName(), is("阪神タイガース"));
	}
	@Test
	public void baseballServiceTest3() {
		Team team = baseballService.showDetail(3);
		assertThat("TC3:期待値と実際の結果が異なります", team.getTeamName(), is("中日ドラゴンズ"));
	}
	@Test
	public void baseballServiceTest4() {
		Team team = baseballService.showDetail(4);
		assertThat("TC4:期待値と実際の結果が異なります", team.getTeamName(), is("横浜DeNAベイスターズ"));
	}
	@Test
	public void baseballServiceTest5() {
		Team team = baseballService.showDetail(5);
		assertThat("TC5:期待値と実際の結果が異なります", team.getTeamName(), is("広島東洋カープ"));
	}
	@Test
	public void baseballServiceTest6() {
		Team team = baseballService.showDetail(6);
		assertThat("TC6:期待値と実際の結果が異なります", team.getTeamName(), is("東京ヤクルトスワローズ"));
	}
	@Test
	public void baseballServiceTest7() {
		Team team = baseballService.showDetail(7);
		assertThat("TC7:期待値と実際の結果が異なります",team,(nullValue()));
		
	}
	@Test
	public void baseballServiceTest8() {
		Team team = baseballService.showDetail(-1);
		assertThat("TC8:期待値と実際の結果が異なります",team,(nullValue()));
	}
	@Test
	public void baseballServiceTest9() {
		Team team = baseballService.showDetail(0);
		assertThat("TC8:期待値と実際の結果が異なります",team,(nullValue()));
	}
	@Test
	public void baseballServiceTest10() {
		Team team = baseballService.showDetail(8);
		assertThat("TC8:期待値と実際の結果が異なります",team,(nullValue()));
	}
}
