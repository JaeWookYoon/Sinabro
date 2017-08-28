package com.sinabro.user.usedboard.service;

import com.sinabro.model.UsedBoardVO;

public interface UsedUpdateArticleService {

	UsedBoardVO getArticle(Integer num);


	void updateArticle(UsedBoardVO UsedBoardVo, String uploadPath);
}
