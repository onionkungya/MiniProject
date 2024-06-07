package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {
	public List<GoodsDTO> goodsList(SqlSession session, String gCategory){
		return session.selectList("com.config.GoodsMapper.goodsList", gCategory);
	}
	
	public GoodsDTO goodsRetrieve(SqlSession session, String gCode){
		return session.selectOne("com.config.GoodsMapper.goodsRetrieve", gCode);
	}
}
