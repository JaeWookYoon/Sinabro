package com.main.sinabro;

import java.sql.DriverManager;

import javax.sql.DataSource;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import javax.inject.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MyOracleConnectionTest {

	@Inject
	private SqlSessionFactory sessionFactory;

	@Test
	public void testFactory() {
		System.out.println(sessionFactory);
	}
	@Test
	public void testConnection()throws Exception{
		
		try(SqlSession session = sessionFactory.openSession()) {
			System.out.println(session+"гого");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
