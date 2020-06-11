package org.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.edu.vo.MemberVO;

public class SampleMapperImpl implements IF_SampleMapper{
	
	@Inject
	//오버라이드 다형성
	private SqlSession sqlSession;
	
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("org.edu.dao.IF_SampleMapper", vo);
	}

	@Override
	public List<MemberVO> selectMember() {
		return sqlSession.selectList("org.edu.dao.IF_SampleMapper");
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("org.edu.dao.IF_SampleMapper", vo);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("org.edu.dao.IF_SampleMapper", userid);
	}

	@Override
	public String getTime() {
		return null;
	}

	@Override
	public String getUname(String uid, String upw) {
		return null;
	}

	@Override
	public String getUserId(String username) {
		return null;
	}

	@Override
	public String searchUname(String type, String keyword) {
		return null;
	}

}
