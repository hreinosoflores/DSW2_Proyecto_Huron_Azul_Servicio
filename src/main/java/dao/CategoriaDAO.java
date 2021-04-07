package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.BeanCategoriaProd;
import sql.ConectaDB;

public class CategoriaDAO {
	
	private ConectaDB sql=new ConectaDB();
	
	public BeanCategoriaProd[] listar(){
		List<BeanCategoriaProd> temp = new ArrayList<BeanCategoriaProd>();
		
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from categoriaprod order by desccat asc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BeanCategoriaProd c = new BeanCategoriaProd();
				c.setCODCAT(rs.getLong(1) + ""); 
				c.setDESCCAT(rs.getString(2));  
				temp.add(c);
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp.toArray(new BeanCategoriaProd[] {});
	}


}
