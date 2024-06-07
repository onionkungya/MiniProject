package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCategory = request.getParameter("gCategory");
		System.out.println(gCategory);
		if(gCategory == null) {
			gCategory = "top";
		}
		GoodsService service = new GoodsServiceImpl(new GoodsDAO());
		List<GoodsDTO> goodsList = service.goodsList(gCategory);
		request.setAttribute("goodsList", goodsList);
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
