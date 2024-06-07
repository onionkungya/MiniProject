package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	public MemberDTO idCheck(SqlSession session, String userid) {
		return session.selectOne("com.config.MemberMapper.idCheck", userid);
	}
	public int memberAdd(SqlSession session, MemberDTO dto) {
		return session.insert("com.config.MemberMapper.memberAdd", dto);
	}
	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		return session.selectOne("com.config.MemberMapper.login", map);
	}
	public MemberDTO mypage(SqlSession session, String userid) {
		return session.selectOne("com.config.MemberMapper.mypage", userid);
	}
}
