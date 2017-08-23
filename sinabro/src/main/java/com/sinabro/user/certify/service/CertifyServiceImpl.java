package com.sinabro.user.certify.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import com.sinabro.user.certify.dao.CertifyDAO;
import com.sinabro.util.MakeCode;

public class CertifyServiceImpl implements CertifyService {

	
	private CertifyDAO certifyDAO;
	private JavaMailSender javaMailSender;
	
	
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}



	public void setCertifyDAO(CertifyDAO certifyDAO) {
		this.certifyDAO = certifyDAO;
	}



	@Override
	public String getSmsService(Object obj) {
		// TODO Auto-generated method stub
		int result=certifyDAO.getPhone(obj);
		System.out.println(result+"개 검색");
		Map<String,Object>map=(Map)obj;
		String phone=(String)map.get("phone");
		String code="no";
		if(result>0) {
			code=MakeCode.makeCode();
			MimeMessage msg=javaMailSender.createMimeMessage();
			String front=phone.substring(0, 3);
			if(front.equals("010")) {
				front="+8210";
			}
			StringBuilder str=new StringBuilder();
			str.append(front);
			str.append(phone.substring(3, phone.length()));
			phone=str.toString();
			try {
				msg.setSubject("중고 판매 인증 메시지입니다.");
				msg.setText("인증코드"+code+"</br>"+"해당 메시지는 웹에서 전송되었습니다.");
				msg.setRecipients(RecipientType.TO, phone);
				
			}catch(MessagingException me) {
				me.printStackTrace();
			}
			try {
				javaMailSender.send(msg);
				System.out.println("전송 완료");
				System.out.println(code+"Code");
			}catch(MailException me) {
				me.printStackTrace();
			}
		}
		
		return code;
	}

}
