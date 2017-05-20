package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.QueryService;

public class AutoReplyServlet extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/* 
 * 自动回复功能控制层
 */
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("i have run");
	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out=resp.getWriter();
	QueryService queryService=new QueryService();
	out.write(queryService.queryByCommand(req.getParameter("content")));
	out.flush();
	out.close();
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
