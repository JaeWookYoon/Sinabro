package com.sinabro.user.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.util.Paging;
import com.sinabro.user.board.service.BoardListService;
import com.sinabro.model.BoardVO;

@Controller
public class ListController {
	private BoardListService boardListService;
	private Paging boardPaging;

	public BoardListService getBoardListService() {
		return boardListService;
	}

	public void setBoardListService(BoardListService boardListService) {
		this.boardListService = boardListService;
	}

	public Paging getBoardPaging() {
		return boardPaging;
	}

	public void setBoardPaging(Paging boardPaging) {
		this.boardPaging = boardPaging;
	}

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int pagenavi = 5;
		String search_type = request.getParameter("search_type");
		String search_text = request.getParameter("search_text");
		if (search_text != null)
			search_text = new String(search_text.getBytes("8859_1"), "utf-8");
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
		int count = this.boardListService.getListCount(map);
		int number = count - (currentPage - 1) * pageSize;
		boardPaging.setPaging(pageSize, pagenavi, count, currentPage);
		map.put("startRow", boardPaging.getWriting_Start());
		map.put("endRow", boardPaging.getWriting_End());
		List<BoardVO> boardList = this.boardListService.getBoardList(map);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("boardList", boardList);
		model.put("count", count);
		model.put("number", number);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("pageNum", pageNum);
		model.put("bp", boardPaging);
		model.put("startRow", boardPaging.getWriting_Start());
		model.put("endRow", boardPaging.getWriting_End());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/list");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
