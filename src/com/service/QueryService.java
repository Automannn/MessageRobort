package com.service;

import java.util.List;
import java.util.Random;

import com.dao.CommandDao;
import com.dao.Messagedao;
import com.domain.Command;
import com.domain.CommandContent;
import com.domain.Message;
import com.util.Iconst;

public class QueryService {
	/**
	 *查询相关的业务功能
	 */
	public List<Message> queryMessageList(String command,String description){
		Messagedao messagedao=new Messagedao();
		//查询并返回结果
		return messagedao.queryMessageList(command, description);
	}
	public String queryByCommand(String command) {
		CommandDao commandDao=new CommandDao();
		List<Command>commandList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			commandList=commandDao.queryCommandList(null, null);
			StringBuilder result=new StringBuilder();
			for (int i = 0; i < commandList.size(); i++) {
				if (i!=0) {
					result.append("<br/>");
				}
				result.append("回复["+commandList.get(i).getName()+"]可以查看"+commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList=commandDao.queryCommandList(command, null);
		if (commandList.size()>0) {
			List<CommandContent>contentList=commandList.get(0).getContentList();
			int i=new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
	

}
