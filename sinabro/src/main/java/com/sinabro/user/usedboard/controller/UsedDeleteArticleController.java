package com.sinabro.user.usedboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.service.UsedDeleteArticleService;

@Controller
public class UsedDeleteArticleController {
	private UsedDeleteArticleService useddeleteArticleService;

	public UsedDeleteArticleService getUseddeleteArticleService() {
	return useddeleteArticleService;
}




	public void setUseddeleteArticleService(UsedDeleteArticleService useddeleteArticleService) {
	this.useddeleteArticleService = useddeleteArticleService;
}




@RequestMapping(value = "useddeleteProc.do", method = RequestMethod.GET)
   public ModelAndView onSubmit(Integer num, UsedBoardVO usedBoardVo) {
         this.useddeleteArticleService.deleteArticle(usedBoardVo.getNum());
         return new ModelAndView("redirect:usedlist.do");

   }
}