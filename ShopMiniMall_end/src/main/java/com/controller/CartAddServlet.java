package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;

@WebServlet("/cartAdd")
public class CartAddServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {
			String userid = dto.getUserid();
			String gSize = request.getParameter("gSize");
			String gColor = request.getParameter("gColor");
			String gAmount = request.getParameter("gAmount");
			String gCode = request.getParameter("gCode");
			
			CartDTO cartDTO = new CartDTO();
			cartDTO.setUserid(userid);
			cartDTO.setgSize(gSize);
			cartDTO.setgColor(gColor);
			cartDTO.setgAmount(Integer.parseInt(gAmount));
			cartDTO.setgCode(gCode);
			
			CartService service = new CartServiceImpl(new CartDAO());
			int n = service.cartAdd(cartDTO);
			
			nextPage="goods/cartAddSuccess.jsp";
			
		}else {
			nextPage="member/checkLogin.jsp";
		}
		response.sendRedirect(nextPage);
		
	}
}
