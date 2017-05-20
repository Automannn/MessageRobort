package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.db.DBAccess;
import com.domain.Message;

/**
 *与message表对应的数据库方法
 */
public class Messagedao {
	/**
	 *检索数据的方法
	 */
	public List<Message>queryMessageList(String command,String description){
		DBAccess dbAccess=new DBAccess();
		List<Message>messageList=new ArrayList<Message>();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			//通过sqlSession执行sql语句,将message对象中的相应字段映射到Message.xml文件中对应的数据库字段
			messageList=sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	/**
	 * 单条删除的方法
	 */
	public void deleteOne(int id){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlsession执行sql语句
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
		/**
		 * 多条删除的方法
		 */
		public void deleteBatch(List<Integer> ids){
			DBAccess dbAccess=new DBAccess();
			SqlSession sqlSession=null;
			try {
				sqlSession=dbAccess.getSqlSession();
				//通过sqlsession执行sql语句
				sqlSession.delete("Message.deleteBatch",ids);
				sqlSession.commit();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				if (sqlSession!=null) {
					sqlSession.close();
				}
			}
	}

}
