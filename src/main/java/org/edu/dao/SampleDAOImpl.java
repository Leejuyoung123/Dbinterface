package org.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.edu.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAOImpl implements IF_SampleDAO {
	
	private static String mapperQuery = "org.edu.dao.IF_SampleDAO";
	
	@Inject
	private SqlSession sqlSession;
	//오바라이드-다형성
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(mapperQuery + ".insertMember", vo);		
	}

	@Override
	public List<MemberVO> selectMember() {
		return sqlSession.selectList(mapperQuery + ".selectMember");
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update(mapperQuery + ".updateMember", vo);		
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete(mapperQuery + ".deleteMember", userid);		
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUname(String uid, String upw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserId(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchUname(String type, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}