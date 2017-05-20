package com.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	public SqlSession getSqlSession() throws IOException{
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader=Resources.getResourceAsReader("com/config/configuration.xml");
		//ͨ�������ļ�����һ��sqlsessionfactory
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//ͨ��sqlsessionfactory����һ�����ݿ�Ự
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession;
	}

}
