package com.eggTap.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	Logger logger = LogManager.getLogger(MemberDao.class);

	private static final String NAMESPACE = "com.eggTap.demo.";
	@Autowired
	private SqlSession sqlSession = null;

	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {

		logger.info("memberList 호출성공");

		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "memberList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}

	public int memberInsert(Map<String, Object> pMap) {

		logger.info("memberInsert 호출성공");
		int result = -99;

		try {
			result = sqlSession.insert(NAMESPACE + "memberInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}

}
