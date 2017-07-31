package com.sinabro.user.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinabro.model.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final String namespace = "com.sinabro.user.board.dao.";

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<BoardVO> getList(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		if (map.get("search_type").equals("all")) {
			return sqlSessionTemplate.selectList(namespace + "getAllList", obj);
		} else if (map.get("search_type").equals("writer")) {
			return sqlSessionTemplate.selectList(namespace + "getWriterList", obj);
		} else if (map.get("search_type").equals("subject")) {
			return sqlSessionTemplate.selectList(namespace + "getSubjectList", obj);
		} else if (map.get("search_type").equals("content")) {
			return sqlSessionTemplate.selectList(namespace + "getContentList", obj);
		} else {
			return sqlSessionTemplate.selectList(namespace + "getList", obj);
		}
	}

	@Override
	public int getListCount(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		if (map.get("search_type").equals("writer")) {
			return sqlSessionTemplate.selectOne(namespace + "getWriterCount", obj);
		} else if (map.get("search_type").equals("subject")) {
			return sqlSessionTemplate.selectOne(namespace + "getSubjectCount", obj);
		} else if (map.get("search_type").equals("content")) {
			return sqlSessionTemplate.selectOne(namespace + "getContentCount", obj);
		} else {
			return sqlSessionTemplate.selectOne(namespace + "getAllCount", obj);
		}
	}

	@Override // 글쓰기
	public void insertArticle(BoardVO boardVo) {
		sqlSessionTemplate.insert(namespace + "insertArticle", boardVo);

	}

	// 글보기
	@Override
	public BoardVO getArticle(Integer num) {
		return sqlSessionTemplate.selectOne(namespace + "getArticle", num);
	}

	// 글수정
	@Override
	public void updateArticle(BoardVO boardVo) {
		sqlSessionTemplate.update(namespace + "updateArticle", boardVo);
	}



	// 글삭제
	@Override
	public void deleteArticle(Integer num) {
		sqlSessionTemplate.delete(namespace + "deleteArticle", num);
	}

}
