package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

public class GoodsServiceImpl implements GoodsService{
	GoodsDAO goodsDAO;
	
	public GoodsServiceImpl(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
	@Override
	public List<GoodsDTO> goodsList(String gCategory) {
		
		List<GoodsDTO> goodsList=null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			goodsList=goodsDAO.goodsList(session, gCategory);
		}finally {
			session.close();
		}
		return goodsList;
	}
	
	@Override
	public GoodsDTO goodsRetrieve(String gCode) {
		
		GoodsDTO dto=null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dto = goodsDAO.goodsRetrieve(session, gCode);
		}finally {
			session.close();
		}
		return dto;
	}
}
