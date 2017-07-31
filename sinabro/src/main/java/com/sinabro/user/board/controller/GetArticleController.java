package com.sinabro.user.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.user.board.service.GetArticleService;
import com.sinabro.model.BoardVO;

@Controller
public class GetArticleController {//기사불러오기
	private GetArticleService getArticleService;

	public void setGetArticleService(GetArticleService getArticleService) {
		this.getArticleService = getArticleService;
	}
	
	@RequestMapping(value="content.do", method= RequestMethod.GET)//content view
	public ModelAndView getArticle(Integer num){
		BoardVO boardVo = this.getArticleService.getArticle(num);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("vo",boardVo);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/content");
		mav.addAllObjects(model);
		return mav;
	}
}
