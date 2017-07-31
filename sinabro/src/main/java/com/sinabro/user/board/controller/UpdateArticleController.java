package com.sinabro.user.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.BoardVO;
import com.sinabro.user.board.service.UpdateArticleService;

@Controller
public class UpdateArticleController {

	private UpdateArticleService updateArticleService;

	public void setUpdateArticleService(UpdateArticleService updateArticleService) {
		this.updateArticleService = updateArticleService;
	}

	@RequestMapping(value = "updateForm.do", method = RequestMethod.GET)
	public ModelAndView setView(Integer num) {
		BoardVO boardVo = this.updateArticleService.getArticle(num);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vo", boardVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/updateForm");
		mav.addAllObjects(model);
		return mav;
	}

	@RequestMapping(value = "updateForm.do", method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request, BoardVO boardVo) throws Exception {
		
			return new ModelAndView();
		}
	

}