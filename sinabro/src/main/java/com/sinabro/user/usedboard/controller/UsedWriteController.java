package com.sinabro.user.usedboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.service.UsedWriteService;

@Controller
public class UsedWriteController {

	private UsedWriteService usedWriteService;
   
   

   public void setUsedWriteService(UsedWriteService usedWriteService) {
	this.usedWriteService = usedWriteService;
}

@RequestMapping(value = "usedwriteForm.do",method = RequestMethod.GET)
   public ModelAndView setView(HttpServletRequest request) {
     
	   
	      ModelAndView model=new ModelAndView();
	      HttpSession session=request.getSession(false);
	      if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
	    	  model.addObject("check", false);
	    	  model.setViewName("usedBoard/list");
	    	  return model;
	      }else {
	    	  model.setViewName("usedBoard/writeForm");
	    	  return model;
	      }
   }

   @RequestMapping(value="/usedwrite.do",method = RequestMethod.POST)
   public ModelAndView onSubmit(HttpServletRequest request, UsedBoardVO usedBoardVo)throws Exception{
      // 글쓰기 DB에 저장
      System.out.println("일단 왔어dd");
      System.out.println(request.getParameter("content"));
      ModelAndView model=new ModelAndView();
      HttpSession session=request.getSession(false);
      if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
    	  model.addObject("check", false);
    	  model.setViewName("usedBoard/list");
    	  return model;
      }else {
    	  System.out.println(usedBoardVo.getContent()+"글입니다.");
    	  usedBoardVo.setId((String)session.getAttribute("loginId"));
      this.usedWriteService.insertWriting(usedBoardVo);
      model.setViewName("redirect:/usedlist.do");
      return model;
      }
   }
   
}