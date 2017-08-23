package com.sinabro.user.page.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.BoardVO;
import com.sinabro.user.page.service.UserPageService;
import com.sinabro.util.Paging;

@Controller
public class UserPageController {

	private UserPageService userPageService ;
	public void setUserPageService(UserPageService userPageService) {
		this.userPageService = userPageService;
	}
	@RequestMapping(value="Mypage.do")
	public ModelAndView getMyPage(HttpServletRequest request) throws Exception{
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.addObject("loginError", true);
			model.setViewName("userpage/myPage");
		}else {
			model.setViewName("userpage/myPage");
		}
		return model;
	}
	@RequestMapping(value="getMyboard.do")
	public ModelAndView getMyboard(HttpServletRequest request) {
		int pageNum=0;
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		Paging page=new Paging();
		Map<String,Object> map=new HashMap<String,Object>();
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.addObject("loginError", true);
			model.setViewName("userpage/myPage");
		}else {
			if(request.getParameter("pageNum")==null||request.getParameter("pageNum").equals(null)) {
				pageNum=1;
			}else {
				pageNum=Integer.valueOf(request.getParameter("pageNum"));
			}
			System.out.println(session.getAttribute("loginId"));
			String id=(String)session.getAttribute("loginId");
			map.put("id",id);
			int count=userPageService.getMycount(id);
			page.setPaging(10, 5, count, pageNum);
			map.put("startRow", page.getWriting_Start());
			map.put("endRow", page.getWriting_End());
			List<BoardVO> vo=userPageService.getMyboard(map);
			int endPage=page.getPage_End();
			int pageCount=page.getPage_Count();
			if(endPage>=pageCount) {
				endPage=pageCount;
			}
			model.addObject("startPage", page.getPage_Start());
			model.addObject("endPage",endPage);
			model.addObject("pre", page.isPre());
			model.addObject("post", page.isNext());
			model.addObject("list", vo);
			model.setViewName("userpage/MyBoard");
		}
		return model;
	}
}
