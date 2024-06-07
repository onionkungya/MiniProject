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

@WebServlet("/login-exec")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		MemberService service = new MemberServiceImpl(new MemberDAO());
		MemberDTO dto = service.login(map);
		String nextPage = null;
		if(dto != null) {
			nextPage = "main";
			HttpSession session = request.getSession();
			session.setAttribute("login", dto);
			session.setMaxInactiveInterval(60*60); //1시간동안 유지(기본은 30분)
		}else {
			nextPage = "member/loginFail.jsp";
		}
		response.sendRedirect(nextPage);
	}
}
