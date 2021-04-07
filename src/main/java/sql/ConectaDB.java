package sql;

import java.sql.*;

public class ConectaDB {
	public Connection getConexion() {
		Connection cn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_huron_azul","root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cn;
	}
	

}
