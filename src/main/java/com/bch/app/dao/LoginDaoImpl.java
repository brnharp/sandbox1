package com.bch.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bch.app.models.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	private static final Logger log = LogManager.getLogger(LoginDaoImpl.class);
	
	@Autowired
	private DataSource dataSource;

	public User login(String sec1, String sec2) {
		User result = null;
		StringBuffer query = new StringBuffer();
		query.append("SELECT ID, FNAME, LNAME ");
		query.append("FROM SANDBOX.USERS ");
		query.append("WHERE SECURITY_ONE = ? ");
		query.append("AND SECURITY_TWO = ? ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, sec1);
			pstmt.setString(2, sec2);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = new User();
				result.setId(rs.getInt("id"));
				result.setFirstName(rs.getString("fname"));
				result.setLastName(rs.getString("lname"));
				result.setAuthenticated(true);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return result;
	}

}
