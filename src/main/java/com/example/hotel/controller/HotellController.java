package com.example.hotel.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotel.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotellController {
	
	@Autowired
	HotelService hotelService;
	@Autowired
	ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "hotel/serch";
	}
	@RequestMapping("/serch")
	public String serch() {
		return 
	}
}
