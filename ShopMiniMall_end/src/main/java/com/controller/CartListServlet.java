package com.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/cartList")
public class CartListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {

			CartService service = new CartServiceImpl(new CartDAO());
			List<CartDTO> cartList = service.cartList(dto.getUserid());
			request.setAttribute("cartList", cartList);
			nextPage="cartList.jsp";
			
		}else {
			nextPage="member/checkLogin.jsp";
		}
		//response.sendRedirect(nextPage);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
