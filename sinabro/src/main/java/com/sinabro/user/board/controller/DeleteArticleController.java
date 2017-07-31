package com.sinabro.user.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.user.board.service.DeleteArticleService;
import com.sinabro.model.BoardVO;

@Controller
public class DeleteArticleController {
	private DeleteArticleService deleteArticleService;

	public DeleteArticleService getDeleteArticleService() {
		return deleteArticleService;
	}

	public void setDeleteArticleService(DeleteArticleService deleteArticleService) {
		this.deleteArticleService = deleteArticleService;
	}

	
	@RequestMapping(value = "deleteProc.do", method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request) {
		
		return new ModelAndView();
	}
}