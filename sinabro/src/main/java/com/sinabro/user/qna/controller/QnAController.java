package com.sinabro.user.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QnAController {

	@RequestMapping(value="QnA.do")
	public String getQnaBoard() {
		return "qna/qnaboard";
	}
	
}
