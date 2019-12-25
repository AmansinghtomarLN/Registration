package registration.aman.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Registration;

import org.omg.CORBA.portable.ApplicationException;

import registration.aman.bean.RegistrationBean;


public class RegistrationModel {

	String driver ="com.mysql.jdbc.Driver";
	String connection = "jdbc:mysql://localhost:3306/practice" ;
	String user = "root";
	String password ="root";

	public String primary() throws Exception{
		System.out.println("Model primary method is running");
		String primary = "usr-"+nextPK();
		return primary;
	}
	public  Integer nextPK() throws Exception {
	
		System.out.println("nextPK Started");

		int pk = 0;

		try {
			Class.forName(driver);
			System.out.println("Driver loaded");
			Connection conn = DriverManager.getConnection(connection, user, password);	
			PreparedStatement pstmt = conn.prepareStatement("SELECT max(id) FROM user ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			
			}
			rs.close();

		} catch (Exception e) {
			throw new Exception("Exception : Exception in getting PK");
		} 
		System.out.println("Method nextPK Ended"+pk);
		return pk + 1;
	}

	
	public long add(RegistrationBean bean) throws Exception  {
	int pk= nextPK();
		System.out.println("Registration add method Started");
		
		Class.forName(driver);
		System.out.println("Driver loaded");
		Connection conn = DriverManager.getConnection(connection, user, password);	
		RegistrationBean existbean = findByLogin(bean.getEmail());

		if (existbean != null) {
			throw new Exception("Login Id already exists");
		}

		try {
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, primary());
			pstmt.setString(3, bean.getFirstName());
			pstmt.setString(4, bean.getLastName());
			pstmt.setString(5, bean.getNumber());
			pstmt.setString(6, bean.getEmail());
			pstmt.setString(7, bean.getPassword());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new Exception("Exception : add rollback exception " + ex.getMessage());
			}
			throw new Exception("Exception : Exception in add User");
		}
		System.out.println("Method add Ended");
		return pk;
	}


	public RegistrationBean findByLogin(String email) throws Exception {
		System.out.println("findByLogin Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM USER WHERE mail=?");
		RegistrationBean bean = null;

		try {
			
			Class.forName(driver);
			System.out.println("Driver loaded");
			Connection conn = DriverManager.getConnection(connection, user, password);
		
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RegistrationBean();
				bean.setFirstName(rs.getString(3));
				bean.setLastName(rs.getString(4));
				bean.setNumber(rs.getString(5));
				bean.setEmail(rs.getString(6));
				bean.setNumber(rs.getString(7));
				
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		
			throw new Exception("Exception : Exception in getting User by login");
		}
		System.out.println("userModel findByLogin ended");
		return bean;
	}


}
