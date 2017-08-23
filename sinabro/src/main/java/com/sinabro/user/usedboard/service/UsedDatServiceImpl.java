package com.sinabro.user.usedboard.service;

import java.util.List;

import com.sinabro.model.CommentVO;

import com.sinabro.user.usedboard.dao.UsedDatDAO;

public class UsedDatServiceImpl implements UsedDatService {

	private UsedDatDAO usedDatDAO;
	
	
	
	public void setUsedDatDAO(UsedDatDAO usedDatDAO) {
		this.usedDatDAO = usedDatDAO;
	}

	@Override
	public int insertDat(CommentVO vo) {
		// TODO Auto-generated method stub
		return usedDatDAO.insertDat(vo);
	}

	@Override
	public List<CommentVO> getDat(int num) {
		// TODO Auto-generated method stub
		return usedDatDAO.getDat(num);
	}

}
