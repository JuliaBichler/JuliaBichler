package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.stream.events.Comment;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;


public class DBManager {
	
	private static DBManager instance = null;
	Connection con;
	private DBManager db;
	public DBManager() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hash","root","1009");  
	}
	
	public static DBManager getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) 
        {
            instance = new DBManager(); 
        }
        return instance;
	}
	
	public void initDBManager(String user, String password, String url, String driver) throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		
		con=DriverManager.getConnection(url, user, password);
	}

	public void close() throws SQLException {
		con.close();
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/

	public void registerUser(String username, String password) throws SQLException { 
		  
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String pwd = bcrypt.encode(password);
		String sql="INSERT INTO users(username,password) VALUES ('"+username+"','"+pwd+"')";
		Statement stmt = con.createStatement();
		//stmt.setString(1,username);
		//stmt.setString(2,password);
		stmt.executeUpdate(sql);
		stmt.close();
		
		System.out.println("User registriert");
	}
	
	public void loginUser(String n, String p) throws SQLException {
		PreparedStatement ps=con.prepareStatement("SELECT username, password FROM users WHERE username=? AND password=?");
		ps.setString(1,n);  
		ps.setString(2,p); 
		ps.executeQuery();
		ps.close();
		
		System.out.println("logged in");
	}

	public boolean userExists(String n, String p) throws ClassNotFoundException, SQLException {
		db = new DBManager();
		String sql = "SELECT * FROM users WHERE username=?";
		PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, n);
		
        ResultSet rs = stmt.executeQuery();
        boolean userexists = rs.next();
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        userexists = bcrypt.matches(p, bcrypt.encode(p));
        
        System.out.println(userexists);
        stmt.close();
        rs.close();
        		
        return userexists;              
        }
}








