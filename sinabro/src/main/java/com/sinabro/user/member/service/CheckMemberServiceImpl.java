package com.sinabro.user.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import com.sinabro.user.member.dao.CheckMemberDAO;
import com.sinabro.util.BCrypt;
import com.sinabro.util.MakeCode;
import com.sinabro.util.SHA256;

public class CheckMemberServiceImpl implements CheckMemberService {

	private SHA256 sha;
	private BCrypt crypt;
	public void setSha(SHA256 sha) {
		this.sha = sha;
	}

	public void setCrypt(BCrypt crypt) {
		this.crypt = crypt;
	}

	private CheckMemberDAO checkDAO;
	private JavaMailSender mailsender;
	public void setMailsender(JavaMailSender mailsender) {
		this.mailsender = mailsender;
	}

	public void setCheckDAO(CheckMemberDAO checkDAO) {
		this.checkDAO = checkDAO;
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		String result=checkDAO.checkId(id);
		if(result!=null) {
		return false;
		}else {
			return true;
		}
	}

	@Override
	public String findId(String name,String email) {
		// TODO Auto-generated method stub
		
		String code="NO";
		System.out.println(code);
		System.out.println(name+"�̸�");
		List<String> mail=checkDAO.findId(name.trim());
		System.out.println(mail+"Mail");
		for(int i=0;i<mail.size();i++) {
		if(email.trim().equals(mail.get(i).trim())){//��ġ�ϴ� ������ ���� ���.
			code=MakeCode.makeCode();
			MimeMessage msg=mailsender.createMimeMessage();
			try {
				msg.setSubject("���̵� ã�� �̸��� �����Դϴ�.");
				msg.setText("�����ڵ�"+code);
				msg.setRecipients(RecipientType.TO, email);
				System.out.println("�����Ϸ�");
			}catch(MessagingException me) {
				me.printStackTrace();
			}
			try {
				mailsender.send(msg);
				System.out.println("���� �Ϸ�");
				System.out.println(code+"Code");
			
			}catch(MailException me) {
				me.printStackTrace();
			}
			
		}else {
			
		}
		}
		return code;
		}

	@Override
	public List<String> getId(String email) {
		// TODO Auto-generated method stub
		
		return checkDAO.getId(email);
	}
	@Override
	public String findPw(String id,String email) {
		String code=MakeCode.makeCode();
		System.out.println(code);
		System.out.println(id+"id");
		String mail=checkDAO.findPw(id.trim());
		System.out.println(mail+"Mail");
		if(email.trim().equals(mail.trim())){//�̸����� ���� ���.
			
			MimeMessage msg=mailsender.createMimeMessage();
			try {
				msg.setSubject("�ӽ� ��й�ȣ �߱� �̸��� �����Դϴ�.");
				msg.setText("�����ڵ�"+code);
				msg.setRecipients(RecipientType.TO, email);
				System.out.println("�����Ϸ�");
			}catch(MessagingException me) {
				me.printStackTrace();
			}
			try {
				mailsender.send(msg);
				System.out.println("���� �Ϸ�");
				System.out.println(code+"Code");
				return code;
			}catch(MailException me) {
				me.printStackTrace();
			}
			return code;
		}else {//�̸����� �ٸ���� ����
			return "NO";
		}
	}

	@Override
	public String changPw(String id) {
		// TODO Auto-generated method stub
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("id", id);
		String pw=MakeCode.makeCode();
		String sh=sha.getString(pw.getBytes());
		String password=BCrypt.hashpw(sh, BCrypt.gensalt(12));
		map.put("password", password);
		checkDAO.changePw(map);
		return pw;
	}
	
}

