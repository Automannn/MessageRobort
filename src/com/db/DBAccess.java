package com.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	public SqlSession getSqlSession() throws IOException{
		//通过配置文件获取数据库连接信息
		Reader reader=Resources.getResourceAsReader("com/config/configuration.xml");
		//通过配置文件生成一个sqlsessionfactory
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//通过sqlsessionfactory创建一个数据库会话
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession;
	}

}
