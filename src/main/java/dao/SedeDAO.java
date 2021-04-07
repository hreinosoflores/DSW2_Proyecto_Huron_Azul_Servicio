package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.BeanSede;
import sql.ConectaDB;

public class SedeDAO {

private ConectaDB sql=new ConectaDB();
	
	public BeanSede[] listar(){
		List<BeanSede> temp = new ArrayList<BeanSede>();
		
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM sede order by REFSEDE asc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BeanSede s = new BeanSede();
				s.setCODSEDE(rs.getLong(1) + ""); 
				s.setREFSEDE(rs.getString(2));  
				s.setDIRSEDE(rs.getString(3));  
				temp.add(s);
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp.toArray(new BeanSede[] {});
	}
}
