package com.example.hotel.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotel.domain.Hotel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {
	@Autowired
	HotelService hotelService;
	
	@Test
	public void HotelServiceTest1() {
		List<Hotel> hotelList = hotelService.serchHotel(null);
		assertThat("TC1:期待値と実際の結果が異なります", hotelList.size(), is(5));
		assertThat("TC1:期待値と実際の結果が異なります", hotelList.get(0).getHotelName(), is("パレスホテル東京"));
		assertThat("TC1:期待値と実際の結果が異なります", hotelList.get(4).getHotelName(), is("ホテルローズガーデン新宿"));
	}
	@Test
	public void HotelServiceTest2() {
		List<Hotel> hotelList = hotelService.serchHotel(20000);
		System.out.println(hotelList);
		assertThat("TC2:期待値と実際の結果が異なります", hotelList.size(), is(5));
		assertThat("TC2:期待値と実際の結果が異なります", hotelList.get(0).getHotelName(), is("パレスホテル東京"));
		assertThat("TC2:期待値と実際の結果が異なります", hotelList.get(4).getHotelName(), is("ホテルローズガーデン新宿"));
	}
	@Test
	public void HotelServiceTest3() {
		List<Hotel> hotelList = hotelService.serchHotel(10000);
		assertThat("TC3:期待値と実際の結果が異なります", hotelList.size(), is(3));
		assertThat("TC3:期待値と実際の結果が異なります", hotelList.get(0).getHotelName(), is("横浜ベイホテル東急"));
		assertThat("TC3:期待値と実際の結果が異なります", hotelList.get(2).getHotelName(), is("ホテルローズガーデン新宿"));
	}
	@Test
	public void HotelServiceTest4() {
		List<Hotel> hotelList = hotelService.serchHotel(1000);
		assertThat("TC4:期待値と実際の結果が異なります", hotelList.size(), is(0));
	}
	@Test
	public void HotelServiceTest5() {
		List<Hotel> hotelList = hotelService.serchHotel(100000);
		assertThat("TC5:期待値と実際の結果が異なります", hotelList.size(), is(5));
		assertThat("TC5:期待値と実際の結果が異なります", hotelList.get(0).getHotelName(), is("パレスホテル東京"));
		assertThat("TC5:期待値と実際の結果が異なります", hotelList.get(4).getHotelName(), is("ホテルローズガーデン新宿"));
	}
	@Test
	public void HotelServiceTest6() {
		List<Hotel> hotelList = hotelService.serchHotel(0);
		assertThat("TC6:期待値と実際の結果が異なります", hotelList.size(), is(0));
	}
	@Test
	public void HotelServiceTest7() {
		List<Hotel> hotelList = hotelService.serchHotel(-1000);
		assertThat("TC7:期待値と実際の結果が異なります", hotelList.size(), is(0));
	}
	
	


}
