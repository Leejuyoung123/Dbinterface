package org.edu.test;

import java.util.List;

import javax.inject.Inject;

import org.edu.dao.IF_SampleDAO;
import org.edu.service.IF_SampleService;
import org.edu.vo.MemberVO;
// import org.edu.dao.SampleSelectProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration // Junit 과 aop동시 사용 에러 처리를 위함
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class SampleMapperTest {

	/**
	 * hsql 사용시 아래 설정은 무시하셔도 됩니다. 실습시 Mysql 에 아래 3가지 쿼리를 실행 하고 작업 시작 합니다. CREATE
	 * SCHEMA `interface` DEFAULT CHARACTER SET utf8 ; create table member ( userid
	 * varchar(50) not null ,userpw varchar(50) not null ,username varchar(50) not
	 * null ,email varchar(100) ,regdate timestamp default now() ,updatedate
	 * timestamp default now() ,primary key(userid) ) INSERT INTO member VALUES
	 * ('user2','1234','kimilguk','user02@test.com',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
	 * 프로젝트폴더경로 DbInterface/src/main/webapp/WEB-INF/spring/root-context.xml
	 * (Mysql서버접속정보 변경해야 합니다.11)
	 */

	// interface 로 Mybatis 쿼리 사용 DI처리(Dependency Injcetion)
	@Inject
	private IF_SampleDAO mapper;
	@Inject
	private IF_SampleService sampleService;
	// aop 가 현재 작동되면 join point 가 서비스에 있기떄문
	/*
	 * 인터페이스를 mapper 실행가능하게 mapper변수로 지정 IF_SampleMapper mapper = new
	 * IF_SampleMapper(); 클래스를 실행변수로 사용시= >IF_SampleMapper mapper =new
	 */

	@Test
	public void testInsertMember() throws Exception {

		/*
		 * int vRandom =0; Random ran = new Random(); vRandom = ran.nextInt();
		 */
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat();
		String today = formatter.format(new java.util.Date());
		//testSelectMember();

		// 입력하기전에 조회
		//System.out.println("위 쪽은 입력 전 리스트입니다.");
		MemberVO vo = new MemberVO();
		vo.setUserid("user" + today);
		vo.setUserpw("1234");
		vo.setUsername("홍길동2");
		vo.setEmail("user10@test.com");
		sampleService.insertMember(vo);
		//System.out.println("아래 쪽은 입력 후 리스트입니다.");
		//testSelectMember();
		// 입력한 후에 select 조회 할수있음
	}

	@Test
	public void testUpdateMember() {
		MemberVO vo = new MemberVO();
		// 수정은 여러개의 변수값을 변경하기 때문에 MemberVO 클래스 변수를 매개변수로 사용한다.
	/*	testSelectMember();
		System.out.println("수정 전 정보");*/
		vo.setUserid("userid1");
		vo.setUserpw("4321");
		vo.setUsername("성춘향");
		vo.setEmail("abc@abc.com");
		mapper.updateMember(vo);
		/*System.out.println("수정 후 정보.");
		testSelectMember();*/
	}

	@Test
	public void testDeleteMember() {
		/*testSelectMember();*/
		mapper.deleteMember("userid10");
		/*System.out.println("아래는 지운 후 회원 리스트입니다");
		testSelectMember();*/
	}

	@Test
	public void testSelectMember() {
		List<MemberVO> list = mapper.selectMember();
		/*int cnt = 1;
		// list 받은 내용을 vo에 들어감
		for (MemberVO vo : list) {
			System.out.println(" 번호:" + cnt++ + "번" + "아이디:" + vo.getUserid() + " 암호:" + vo.getUserpw() + " 이름:"
					+ vo.getUsername() + "이메일:" + vo.getEmail());

		}*/
	}

	/*
	 * IF_SampleMapper DB 연동방식1 인터페이스로 사용자이름에 해당하는 아이디 검색
	 */
	@Test
	public void testUserId() {
		// System.out.println(mapper.getClass().getName()); //디버그용
		String userid = mapper.getUserId("kimilguk");
		System.out.println("결과1[사용자이름에 해당하는 아이디확인] getUserId() : " + userid);
	}

	// interface 로 단순쿼리 Mysql서버 시간출력.(dB연결 확인 용)
	@Test
	public void testTime() {
		// System.out.println("mapper.getClass().getName() : " +
		// mapper.getClass().getName());
		System.out.println("결과2[db접속시간확인] getTime() : " + mapper.getTime());
	}

	// interface 쿼리로 Mysql서버 member테이블 에서 사용자 이름출력.
	@Test
	public void testUname() {
		System.out.println("mapper.getClass().getName() : " + mapper.getClass().getName());
		String uname = mapper.getUname("user2", "1234");
		System.out.println("결과3[아이디/암호로 검색결과 확인] getUname() : " + uname);
	}

	// interface 쿼리로 Mysql서버의 member테이블 에서 사용자 ID검색 후 검색된 이름출력 단, Mapper 외부 java클래스
	// 사용.
	@Test
	public void testSearchUname() {
		System.out.println(mapper.getClass().getName());
		String keyword = "user2";
		String uname = mapper.searchUname("userid", keyword);
		System.out.println("결과4[mapper외부쿼리로 아이로검색한 사용자이름확인] searchUname() : " + uname);
	}
}
