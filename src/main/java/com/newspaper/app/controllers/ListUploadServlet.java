package com.newspaper.app.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newspaper.app.beans.Articles;
import com.newspaper.app.models.ArticlesModel;

@WebServlet(value = "/listupload")
public class ListUploadServlet extends HttpServlet  {

	private ArticlesModel articlesModel = new ArticlesModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = req.getRequestDispatcher("/views/vvUpload/listupload.jsp");
		try {
			req.setAttribute("listUpload", ArticlesModel.findAll());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String status = req.getParameter("loai");
		if(status != null) {
			Integer stt = Integer.valueOf(status);
			if(stt == 0) {
				try {
					req.setAttribute("listUpload", ArticlesModel.findAll());
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			else{
				req.setAttribute("listUpload", ArticlesModel.findbyStatus(stt));
			}
			
		}
		rd.forward(req, resp);
	}
}
