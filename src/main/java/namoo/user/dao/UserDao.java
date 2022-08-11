package namoo.user.dao;

import java.sql.SQLException;
import java.util.List;

import namoo.user.dto.User;

/**
 * 영속적 데이터 처리를 위한 다양한 기술(JDBC, JPA, iBatis, Hibernate 등)들을 
 * 일관된 방법(메소드 호출)으로 접근할 수 있도록 규약 메소드 선언
 *  * @author 김기정
 *
 */
public interface UserDao {
	/** 회원 가입 */
	public void create(User user) throws SQLException;
	
	/** 사용자 id에 해당하는 정보 반환 */
	public User read(String id) throws SQLException;
	
	/** 사용자 로그인 */
	public User login(String id, String passwd) throws SQLException;
	
	/** 사용자 전체 목록 반환 */
	public List<User> list() throws SQLException;
	

}








