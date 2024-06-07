package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;

public class CartServiceImpl implements CartService{
	CartDAO cartDAO;
	
	public CartServiceImpl(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	
	@Override
	public int cartAdd(CartDTO dto) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			n = cartDAO.cartAdd(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	@Override
	public List<CartDTO> cartList(String userid) {
	List<CartDTO> list=null;
	SqlSession session = MySqlSessionFactory.getSession();
	try{
	list = cartDAO.cartList(session, userid);

	}finally {
	session.close();
	}
	return list;
	}
	
}
