package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.QueryService;

public class ListServlet extends HttpServlet {

	/**
	 * 列表初始化和查询控制
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("utf-8");
		//接收页面的值
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		//调用模型层对处理业务逻辑
		QueryService listService=new QueryService();
		//查询消息列表并传给页面
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		//向页面传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
