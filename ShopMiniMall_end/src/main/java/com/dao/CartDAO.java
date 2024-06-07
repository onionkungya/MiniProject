package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {
	public int cartAdd(SqlSession session, CartDTO dto){
		return session.insert("com.config.CartMapper.cartAdd", dto);
	}
	public List<CartDTO> cartList(SqlSession session, String userid){
		return session.selectList("com.config.CartMapper.cartList", userid);
	}
}
