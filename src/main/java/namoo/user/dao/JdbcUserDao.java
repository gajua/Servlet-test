package namoo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.user.dto.User;

public class JdbcUserDao implements UserDao {
	
	private DataSource dataSource;

	public JdbcUserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO users(id, passwd, name, email)")
          .append(" VALUES (?, ?, ?, ?)");
		try {
			con = dataSource.getConnection();
//			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(con != null)   con.close();
		}
	}

	@Override
	public User read(String id) throws SQLException {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, passwd, name, email, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS DAY') regdate")
          .append(" FROM users")
		  .append(" WHERE id = ?");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
			}
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null)   con.close();
		}
		return user;
	}

	@Override
	public User login(String id, String passwd) throws SQLException {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, passwd, name, email, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS DAY') regdate")
          .append(" FROM users")
		  .append(" WHERE id = ? AND passwd = ?");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
			}
		}finally{
			if(pstmt != null) pstmt.close();
			if(con != null)   con.close();
		}
		return user;
	}
	
	@Override
	public List<User> list() throws SQLException {
		List<User> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, passwd, name, email, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS DAY') regdate")
          .append(" FROM users");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
				list.add(user);
			}
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null)   con.close();
		}
		return list;
	}

}
