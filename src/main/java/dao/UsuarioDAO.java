package dao;

import java.sql.*;

import beans.BeanUsuario;
import sql.ConectaDB;

public class UsuarioDAO {
	
	private ConectaDB sql=new ConectaDB();

	public String registrar(BeanUsuario u) {
		String result = null;
		Connection cn = sql.getConexion();
		try {
			CallableStatement cs = cn.prepareCall("{call SP_REGISTRAR_USUARIO(?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, u.getNOMUSUARIO());
			cs.setString(2, u.getAPEUSUARIO());
			cs.setString(3, u.getDIRECCION());
			cs.setString(4, u.getDNI());
			cs.setInt(5,Integer.parseInt(u.getSEXO()));
			cs.setDate(6,Date.valueOf(u.getFECNAC()));	
			cs.setString(7, u.getEMAIL());
			cs.setString(8, u.getTELEFONO());
			cs.setString(9, u.getIDLOGIN());
			cs.setString(10, u.getPASSWORD());
			cs.executeUpdate();
			result = "Se registró correctamente. Bienvenido(a).";
			
		} catch (Exception e) {
			result = "Hubo un error al registrar: " + e.getMessage();
			e.printStackTrace();
		}finally {
			try {
				cn.close();
			} catch (Exception e2) {
				result = "Hubo un error: " + e2.getMessage();
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	
	public String editar(BeanUsuario u) {
		String result = null;
		Connection cn = sql.getConexion();
		try {
			CallableStatement cs = cn.prepareCall("{call SP_EDITAR_USUARIO(?,?,?,?,?,?)}");
			cs.setLong(1,Long.parseLong(u.getCODUSUARIO()));
			cs.setString(2, u.getDIRECCION());
			cs.setString(3, u.getEMAIL());
			cs.setString(4, u.getTELEFONO());
			cs.setString(5, u.getIDLOGIN());
			cs.setString(6, u.getPASSWORD());	
			cs.executeUpdate();
			result = "Se guardaron los cambios.";
			
		} catch (Exception e) {
			result = "Hubo un error al actualizar: " + e.getMessage();
			e.printStackTrace();
		}finally {
			try {
				cn.close();
			} catch (Exception e2) {
				result = "Hubo un error: " + e2.getMessage();
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public BeanUsuario logueo(String id,String pass) {
		BeanUsuario reg = new BeanUsuario();
		Connection cn = sql.getConexion();
		try {
			CallableStatement cs = cn.prepareCall("{call SP_VALIDAR_LOGUEO(?,?)}");
			cs.setString(1, id);
			cs.setString(2, pass);
			ResultSet rs = cs.executeQuery();
			if(rs.next()) {
				reg.setCODUSUARIO(rs.getLong(1)+"");
				reg.setNOMUSUARIO   (rs.getString(2)); 
				reg.setAPEUSUARIO   (rs.getString(3)); 
				reg.setDIRECCION    (rs.getString(4)); 
				reg.setDNI          (rs.getString(5)); 
				reg.setSEXO         (rs.getInt(6)+""); 
				reg.setFECNAC       (rs.getDate(7)+""); 
				reg.setEMAIL        (rs.getString(8)); 
				reg.setTELEFONO     (rs.getString(9)); 
				reg.setIDLOGIN      (rs.getString(10)); 
				reg.setPASSWORD     (rs.getString(11)); 
				reg.setTIPOUSUARIO  (rs.getInt(12)+""); 
				reg.setESTADO       (rs.getBoolean(13)+""); 
				
			}
			rs.close();
			cs.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reg;
		
		
	}

}
