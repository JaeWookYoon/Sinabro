package com.sinabro.user.board.controller;

import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.user.board.service.WriteService;
import com.sinabro.model.BoardVO;

@Controller
public class WriteController {

   private WriteService writeService;

   public void setWriteService(WriteService writeService) {
      this.writeService = writeService;
   }

   @RequestMapping(value = "writeForm.do",method = RequestMethod.GET)
   public ModelAndView setView(HttpServletRequest request) {
     
	   System.out.println("�ϴ� �Ծ�");
	      ModelAndView model=new ModelAndView();
	      HttpSession session=request.getSession(false);
	      if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
	    	  model.addObject("check", false);
	    	  model.setViewName("board/list");
	    	  return model;
	      }else {
	    	  model.setViewName("board/writeForm");
	    	  return model;
	      }
   }

   @RequestMapping(value="writeForm.do",method = RequestMethod.POST)
   public ModelAndView onSubmit(HttpServletRequest request, BoardVO boardVo)throws Exception{
      // �۾��� DB�� ����
      System.out.println("�ϴ� �Ծ�");
      ModelAndView model=new ModelAndView();
      HttpSession session=request.getSession(false);
      if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
    	  model.addObject("check", false);
    	  model.setViewName("board/list");
    	  return model;
      }else {
      this.writeService.insertWriting(boardVo);
      model.setViewName("redirect:/list.do");
      return model;
      }
   }
   
}