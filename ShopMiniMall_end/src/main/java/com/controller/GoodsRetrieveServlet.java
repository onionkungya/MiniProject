package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;

@WebServlet("/goodsRetrieve")
public class GoodsRetrieveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode = request.getParameter("gCode");
		GoodsService service = new GoodsServiceImpl(new GoodsDAO());
		GoodsDTO dto = service.goodsRetrieve(gCode);
		
		request.setAttribute("goodsRetrieve", dto);
		request.getRequestDispatcher("goodsRetrieve.jsp").forward(request, response);
	}
}
