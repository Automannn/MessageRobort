package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.db.DBAccess;
import com.domain.Message;

/**
 *��message���Ӧ�����ݿⷽ��
 */
public class Messagedao {
	/**
	 *�������ݵķ���
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
			//ͨ��sqlSessionִ��sql���,��message�����е���Ӧ�ֶ�ӳ�䵽Message.xml�ļ��ж�Ӧ�����ݿ��ֶ�
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
	 * ����ɾ���ķ���
	 */
	public void deleteOne(int id){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//ͨ��sqlsessionִ��sql���
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
		 * ����ɾ���ķ���
		 */
		public void deleteBatch(List<Integer> ids){
			DBAccess dbAccess=new DBAccess();
			SqlSession sqlSession=null;
			try {
				sqlSession=dbAccess.getSqlSession();
				//ͨ��sqlsessionִ��sql���
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
