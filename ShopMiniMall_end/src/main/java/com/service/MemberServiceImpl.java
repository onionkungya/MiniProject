package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO memberDAO;
	
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public MemberDTO idCheck(String userid) {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dto = memberDAO.idCheck(session, userid);
		}finally {
			session.close();
		}
		return dto;
	}
	
	@Override
	public int memberAdd(MemberDTO dto) {
		int n=0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			n = memberDAO.memberAdd(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	
	@Override
	public MemberDTO login(HashMap<String, String> map) {
		MemberDTO dto=null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dto = memberDAO.login(session, map);
		}finally {
			session.close();
		}
		return dto;
	}
	
	@Override
	public MemberDTO mypage(String userid) {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dto = memberDAO.mypage(session, userid);
		}finally {
			session.close();
		}
		return dto;
	}
	
}

/*
@Override
public MemberDTO idCheck(String userid) {
	
	MemberDTO dto=null;
	SqlSession session = MySqlSessionFactory.getSession();
	try {
		
	}finally {
		session.close();
	}
	return null;
}
*/