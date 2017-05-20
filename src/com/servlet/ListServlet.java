package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.QueryService;

public class ListServlet extends HttpServlet {

	/**
	 * �б��ʼ���Ͳ�ѯ����
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ���
		req.setCharacterEncoding("utf-8");
		//����ҳ���ֵ
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		//����ģ�Ͳ�Դ���ҵ���߼�
		QueryService listService=new QueryService();
		//��ѯ��Ϣ�б�����ҳ��
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		//��ҳ�洫ֵ
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//��ҳ����ת
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
