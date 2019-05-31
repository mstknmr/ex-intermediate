package com.example.hotel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.hotel.domain.Hotel;

/**
 * ホテルのリポジトリクラス.
 * 
 * @author knmrmst
 *
 */
@Repository
public class HotelRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * ホテルオブジェクトを生成するRowMapper
	 */
	final static private RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking("parking");
		return hotel;
	};
	
	/**
	 * ホテル情報の全件検索.
	 * <p>
	 * データベースにある全てのホテルの情報を取得してリストに格納して返す。
	 * </p>
	 * 
	 * @return ホテル情報の入ったリスト
	 */
	public List<Hotel> findAll(){
		String findAllSql="SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels ORDER BY price DESC;";
		List<Hotel> hotelList = template.query(findAllSql, HOTEL_ROW_MAPPER);
		return hotelList;
	}
	
	/**
	 * 引数以下の値段のホテルの検索.
	 * <p>
	 *	受け取った引数以下の値段のホテルの情報を取得してリストに格納して返す。
	 * </p>
	 * 
	 * @param price 値段
	 * @return　ホテル情報の入ったリスト
	 */
	public List<Hotel> findLessThanPriceHotel(Integer price){
		String findLessThanPriceHotelSql=
				"SELECT id,area_name,hotel_name,address,nearest_station,price,parking "
				+ "FROM hotels  WHERE price <= :price ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = template.query(findLessThanPriceHotelSql,param, HOTEL_ROW_MAPPER);
		return hotelList;
		
	}

}
