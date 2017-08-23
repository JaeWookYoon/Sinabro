package com.sinabro.user.usedboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.CommentVO;

public class UsedDatDAOImpl implements UsedDatDAO {

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.usedboard.dao.";
	
	
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insertDat(CommentVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(namespace+"insertUsedComment", vo);
	}

	@Override
	public List<CommentVO> getDat(int num) {
		// TODO Auto-generated method stub
		List<CommentVO> list=sqlSessionTemplate.selectList(namespace+"getUsedComment", num);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getContent());
			
		}
		return list;
	}

}
