package com.eggTap.demo;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/member/*")
public class RestMemberController {
	
	Logger logger = LogManager.getLogger(RestMemberController.class);
	

	@Autowired
	private MemberLogic memberLogic = null;

	@GetMapping("memberList")
	public String memberList(@RequestParam Map<String,Object> pMap) {
		List<Map<String,Object>> memberList = null;
		logger.info("memberList 호출");
		memberList = memberLogic.memberList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(memberList);
		return result;
	}
	
	
	
	@PostMapping("memberInsert")
	public int memberInsert(@RequestParam Map<String,Object> pMap) {
		
		logger.info("memberInsert 호출");
		int result = 0;
		result = memberLogic.memberInsert(pMap);
		
		return result;
	}
	
	
}
