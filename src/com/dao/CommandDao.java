package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.db.DBAccess;
import com.domain.Command;

/**
 *与指令表对应的数据库操作类
 */
public class CommandDao {
  public List<Command> queryCommandList(String name,String description) {
	DBAccess dbAccess=new DBAccess();
	List<Command> commandList =new ArrayList<Command>();
	SqlSession sqlSession=null;
	try {
		sqlSession=dbAccess.getSqlSession();
		Command command=new Command();
		command.setName(name);
		command.setDescription(description);
		//通过sqlSession执行sql语句
		commandList=sqlSession.selectList("Command.queryCommandList",command);
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		if (sqlSession!=null) {
			sqlSession.close();
		}
	}
	return commandList;
}
}
