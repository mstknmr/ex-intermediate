package com.example.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.baseball.service.BaseballService;

@Controller
@RequestMapping("/baseball")
public class BaseballController {
	@Autowired
	BaseballService baseballService;
	
	@RequestMapping("")
	public String index() {
		System.out.println(baseballService.showDetail(1));
		return "baseball/team-detail";
	}

}
