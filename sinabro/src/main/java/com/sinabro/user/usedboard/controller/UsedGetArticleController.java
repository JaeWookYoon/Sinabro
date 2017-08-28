package com.sinabro.user.usedboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.service.UsedGetArticleService;

@Controller
public class UsedGetArticleController {//기사불러오기
	private UsedGetArticleService usedGetArticleService;
	
	
	public void setUsedGetArticleService(UsedGetArticleService usedGetArticleService) {
		this.usedGetArticleService = usedGetArticleService;
	}


	@RequestMapping(value="usedContent.do", method= RequestMethod.GET)//content view
	public ModelAndView getArticle(Integer num){
		UsedBoardVO usedBoardVo = this.usedGetArticleService.getArticle(num);
		Map<String,Object> model = new HashMap<String,Object>();
		String[] img;
		img = usedBoardVo.getMainimg().split(";");
		model.put("img", img);
		model.put("vo",usedBoardVo);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("usedBoard/content");
		mav.addAllObjects(model);
		
		return mav;
	}
}
