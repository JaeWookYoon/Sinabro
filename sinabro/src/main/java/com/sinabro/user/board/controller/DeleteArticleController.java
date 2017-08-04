package com.sinabro.user.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.BoardVO;
import com.sinabro.user.board.service.DeleteArticleService;

@Controller
public class DeleteArticleController {
   private DeleteArticleService deleteArticleService;

   public DeleteArticleService getDeleteArticleService() {
      return deleteArticleService;
   }

   public void setDeleteArticleService(DeleteArticleService deleteArticleService) {
      this.deleteArticleService = deleteArticleService;
   }


   @RequestMapping(value = "deleteProc.do", method = RequestMethod.GET)
   public ModelAndView onSubmit(Integer num, BoardVO boardVo) {
         this.deleteArticleService.deleteArticle(boardVo.getNum());
         return new ModelAndView("redirect:list.do");

   }
}