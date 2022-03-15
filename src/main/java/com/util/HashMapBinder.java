package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//String id = req.getParameter("id");
//String name = req.getParameter("name");
//String age = req.getParameter("age");

public class HashMapBinder {
	Logger logger = LogManager.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	
	public HashMapBinder() {
	}
	
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
	}
	
	public void bind(Map<String, Object> pMap) {
		logger.info(pMap);
		pMap.clear(); //기존에 들어왔던 정보 비우기
		Enumeration<String> en = req.getParameterNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			logger.info(req.getParameter(key));
			pMap.put(key, req.getParameter(key));
		}
	}
}
