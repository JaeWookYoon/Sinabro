package com.sinabro.user.usedboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.service.UsedBoardListService;
import com.sinabro.util.Paging;

@Controller
public class UsedListController {
	private UsedBoardListService usedBoardListService;
	private Paging usedboardPaging;

	public void setUsedBoardListService(UsedBoardListService usedBoardListService) {
		this.usedBoardListService = usedBoardListService;
	}

	public void setUsedboardPaging(Paging usedboardPaging) {
		this.usedboardPaging = usedboardPaging;
	}

	@RequestMapping(value = "usedlist.do", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
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
			search_type = "all";
		}
		if (search_text == null) {
			search_text = "";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search_type", search_type);
		map.put("search_text", search_text);
		int count = this.usedBoardListService.getListCount(map);
		System.out.println(count + "글 숫자");
		usedboardPaging.setPaging(pageSize, pagenavi, count, currentPage);
		int number = count - (currentPage - 1) * pageSize;
		int startPage = usedboardPaging.getPage_Start();
		int endPage = usedboardPaging.getPage_End();
		int pageCount = usedboardPaging.getPage_Count();
		if (endPage >= pageCount) {
			endPage = pageCount;
		}
		map.put("startRow", usedboardPaging.getWriting_Start());
		map.put("endRow", usedboardPaging.getWriting_End());
		List<UsedBoardVO> usedBoardList = this.usedBoardListService.getUsedBoardList(map);
		System.out.println(usedBoardList + "의 글");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("usedBoardList", usedBoardList);
		model.put("count", count);
		model.put("pageCount", usedboardPaging.getPage_Count());
		model.put("pageBlock", usedboardPaging.getPageBlock());
		model.put("number", number);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("pageNum", pageNum);
		model.put("startPage", startPage);
		model.put("endPage", endPage);
		model.put("bp", usedboardPaging);
		model.put("startRow", usedboardPaging.getWriting_Start());
		model.put("endRow", usedboardPaging.getWriting_End());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("usedBoard/list");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}