package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hotel.domain.Hotel;
import com.example.hotel.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
	@Autowired
	HotelRepository hotelRepository;
	
	/**
	 * ホテル検索機能.
	 * <p>
	 * 引数がnull以外で渡された場合はその値段以下のホテルを検索する。
	 * 引数がnullで渡された場合はホテルを全件検索する。
	 * </p>
	 * 
	 * @param price　値段
	 * @return
	 */
	public List<Hotel> serchHotel(Integer price){
		if(price == null) {
			return hotelRepository.findAll();
		}else {
			return hotelRepository.findLessThanPriceHotel(price);
		}
	}
}
