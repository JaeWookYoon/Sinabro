package com.sinabro.util;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener{

	private static ConcurrentHashMap<String,String>sessionList=new ConcurrentHashMap<String,String>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if(event.getName().equals("loginId")) {
			String accountId=(String)event.getValue();
			if(sessionList.get(accountId)!=null) {
				sessionList.remove(accountId);
			}
			//��������
			sessionList.put(accountId, event.getSession().getId());//�α��� ���� ���̵� ���ǰ� ����.
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if(event.getName().equals("loginId")) {
			String accountId=(String)event.getValue();
			String sessionId=sessionList.get(accountId);//session id
			if(sessionId.equals(event.getSession().getId())) {
				sessionList.remove(accountId);//sessionId�����ϴµ� ���� ���� ���.
			}
		}
	}
		

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
		
	}

}
