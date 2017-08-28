package com.sinabro.user.usedboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.BoardVO;
import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.service.UsedUpdateArticleService;

@Controller
public class UsedUpdateArticleController {

	private UsedUpdateArticleService usedUpdateArticleService;

	public void setUsedUpdateArticleService(UsedUpdateArticleService usedUpdateArticleService) {
		this.usedUpdateArticleService = usedUpdateArticleService;
	}

	@RequestMapping(value = "usedupdateForm.do", method = RequestMethod.GET)
	public ModelAndView setView(Integer num) {
		UsedBoardVO usedBoardVo = this.usedUpdateArticleService.getArticle(num);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vo", usedBoardVo);
		String[] img;
		img = usedBoardVo.getMainimg().split(";");
		model.put("img", img);
		ModelAndView mav = new ModelAndView();
		System.out.println("1");
		mav.setViewName("/usedBoard/updateForm");
		mav.addAllObjects(model);
		return mav;
	}

	@RequestMapping(value = "usedupdate.do", method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request, UsedBoardVO usedBoardVo) throws Exception {

		String uploadPath = request.getRealPath("/images/used");
		System.out.println("1");

		this.usedUpdateArticleService.updateArticle(usedBoardVo, uploadPath);
		return new ModelAndView("redirect:usedlist.do");
	}
}