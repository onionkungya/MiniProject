package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); //세션얻기
		
		//로그인 여부 확인
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {
			nextPage="main";
			session.invalidate();
		}else {
			nextPage="member/checkLogin.jsp";
		}
		response.sendRedirect(nextPage);
	}
}
