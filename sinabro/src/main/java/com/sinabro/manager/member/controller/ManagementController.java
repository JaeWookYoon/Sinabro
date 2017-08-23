package com.sinabro.manager.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.manager.member.service.ManagementServiceImpl;
import com.sinabro.model.MemberVO;
import com.sinabro.util.Paging;

@Controller
public class ManagementController {

	private ManagementServiceImpl managementService;
	private Paging paging;

	public void setManageService(ManagementServiceImpl managementService) {
		this.managementService = managementService;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@RequestMapping(value = "userList.mustang", method = RequestMethod.GET)
	public ModelAndView getUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int pagenavi = 5;
		String search_type = request.getParameter("search_type");
		String search_text = request.getParameter("search_text");

		System.out.println(search_text);
		if (search_type == null) {
			search_type = "";
		}
		if (search_text == null) {
			search_text = "";
		}
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("search_type", search_type);
		map.put("search_text", search_text);
		int count = this.managementService.getUserCount(map);
		paging.setPaging(pageSize, pagenavi, count, currentPage);
		int number = count - (currentPage - 1) * pageSize;
		int startPage = paging.getPage_Start();
		int endPage = paging.getPage_End();
		int pageCount = paging.getPage_Count();
		if (endPage >= pageCount) {
			endPage = pageCount;
		}
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());
		List<MemberVO> userList = this.managementService.userList(map);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userList", userList);
		model.put("count", count);
		model.put("pageCount", paging.getPage_Count());
		model.put("pageBlock", paging.getPageBlock());
		model.put("number", number);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("pageNum", pageNum);
		model.put("startPage", startPage);
		model.put("endPage", endPage);
		model.put("bp", paging);
		model.put("startRow", paging.getWriting_Start());
		model.put("endRow", paging.getWriting_End());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/userListForm");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}

	@RequestMapping(value = "adminList.mustang", method = RequestMethod.GET)
	public ModelAndView getAdminList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int pagenavi = 5;
		String search_type = request.getParameter("search_type");
		String search_text = request.getParameter("search_text");

		System.out.println(search_text);
		if (search_type == null) {
			search_type = "";
		}
		if (search_text == null) {
			search_text = "";
		}
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("search_type", search_type);
		map.put("search_text", search_text);
		int count = this.managementService.getAdminCount(map);
		paging.setPaging(pageSize, pagenavi, count, currentPage);
		int number = count - (currentPage - 1) * pageSize;
		int startPage = paging.getPage_Start();
		int endPage = paging.getPage_End();
		int pageCount = paging.getPage_Count();
		if (endPage >= pageCount) {
			endPage = pageCount;
		}
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());
		List<MemberVO> adminList = this.managementService.adminList(map);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("adminList", adminList);
		model.put("count", count);
		model.put("pageCount", paging.getPage_Count());
		model.put("pageBlock", paging.getPageBlock());
		model.put("number", number);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("pageNum", pageNum);
		model.put("startPage", startPage);
		model.put("endPage", endPage);
		model.put("bp", paging);
		model.put("startRow", paging.getWriting_Start());
		model.put("endRow", paging.getWriting_End());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/adminListForm");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}

	@RequestMapping(value = "userInformation.mustang", method = RequestMethod.GET) // content view
	public ModelAndView userInformation(String id) {
		MemberVO memberVo = this.managementService.getUserInformation(id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vo", memberVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/userInformation");
		mav.addAllObjects(model);
		return mav;
	}

	@RequestMapping(value = "deleteUserInformation.mustang", method = RequestMethod.GET)
	public ModelAndView deleteUserInformation(String id, MemberVO memberVo) {
		this.managementService.deleteUserInformation(memberVo.getId());
		return new ModelAndView("redirect:userList.mustang");
	}

	@RequestMapping(value = "updateUserInformation.mustang", method = RequestMethod.GET)
	public ModelAndView updateUserInformation(String id) {
		MemberVO memberVo = this.managementService.getUserInformation(id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vo", memberVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/updateUserInformation");
		mav.addAllObjects(model);
		return mav;
	}

	@RequestMapping(value = "updateUserInformation.mustang", method = RequestMethod.POST)
	public ModelAndView userOnSubmit(HttpServletRequest request, MemberVO memberVo) throws Exception {
		this.managementService.updateUserInformation(memberVo);
		return new ModelAndView("redirect:userList.mustang");
	}
	
	@RequestMapping(value = "adminInformation.mustang", method = RequestMethod.GET) // content view
	public ModelAndView adminInformation(String id) {
		MemberVO memberVo = this.managementService.getAdminInformation(id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vo", memberVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/adminInformation");
		mav.addAllObjects(model);
		return mav;
	}

	@RequestMapping(value = "deleteAdminInformation.mustang", method = RequestMethod.GET)
	public ModelAndView deleteAdminInformation(String id, MemberVO memberVo) {
		this.managementService.deleteAdminInformation(memberVo.getId());
		return new ModelAndView("redirect:adminList.mustang");
	}

	@RequestMapping(value = "updateAdminInformation.mustang", method = RequestMethod.GET)
	public ModelAndView updateAdminInformation(String id) {
		MemberVO memberVo = this.managementService.getAdminInformation(id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vo", memberVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/updateAdminInformation");
		mav.addAllObjects(model);
		return mav;
	}

	@RequestMapping(value = "updateAdminInformation.mustang", method = RequestMethod.POST)
	public ModelAndView adminOnSubmit(HttpServletRequest request, MemberVO memberVo) throws Exception {
		this.managementService.updateAdminInformation(memberVo);
		return new ModelAndView("redirect:adminList.mustang");
	}
}
