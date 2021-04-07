package dao;

import java.sql.*;
import beans.*;
import sql.ConectaDB;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
	private ConectaDB sql=new ConectaDB();
	
	public BeanProducto[] listar(String TIPO_USUARIO, String P_CATPROD,String P_DESCPROD ){
		List<BeanProducto> temp = new ArrayList<BeanProducto>();
		Connection cn = sql.getConexion();
		try {
			CallableStatement cs = cn.prepareCall("{call SP_LISTAR_PRODUCTO(?,?,?)}");
			cs.setInt(1, Integer.parseInt(TIPO_USUARIO));
			cs.setLong(2, Long.parseLong(P_CATPROD));
			cs.setString(3, P_DESCPROD);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				BeanProducto p = new BeanProducto();
				p.setCODPROD(rs.getLong(1)+"");
				p.setDESCPROD(rs.getString(2)); 
				p.setPREPROD(rs.getDouble(3)+"");
				p.setSTKPROD(rs.getInt(4)+""); 
				p.setFOTOPROD(rs.getString(5)); 
				p.setCATPROD(rs.getLong(6)+"");
				temp.add(p);
			}
			rs.close();
			cs.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp.toArray(new BeanProducto[] {});
	}


	public String registrar(BeanProducto p) {
		String result = null;
		Connection cn = sql.getConexion();
		try {
			CallableStatement cs = cn.prepareCall("{call SP_REGISTRAR_PRODUCTO(?,?,?,?,?)}");
			cs.setString(1, p.getDESCPROD());
			cs.setDouble(2, Double.parseDouble(p.getPREPROD()));
			cs.setInt(3, Integer.parseInt(p.getSTKPROD()));
			cs.setString(4, p.getFOTOPROD());
			cs.setLong(5,Long.parseLong(p.getCATPROD()));			
			cs.executeUpdate();
			result = "Se registró el producto correctamente";
			
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
	
	
	public String editar(BeanProducto p) {
		String result = null;
		Connection cn = sql.getConexion();
		try {
			CallableStatement cs = cn.prepareCall("{call SP_EDITAR_PRODUCTO(?,?,?,?,?,?)}");
			cs.setLong(1,Long.parseLong(p.getCODPROD()));
			cs.setString(2, p.getDESCPROD());
			cs.setDouble(3, Double.parseDouble(p.getPREPROD()));
			cs.setInt(4, Integer.parseInt(p.getSTKPROD()));
			cs.setString(5, p.getFOTOPROD());
			cs.setLong(6, Long.parseLong(p.getCATPROD()));
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
	
	public String inactivar(String codprod) {
		String result = null;
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE PRODUCTO SET STKPROD=0 WHERE CODPROD=?");
			ps.setLong(1, Long.parseLong(codprod));

			ps.executeUpdate();
			result = "Se desactivó el producto. Se eliminó del catálogo para los clientes.";
			
		} catch (Exception e) {
			result = "Hubo un error al cancelar: " + e.getMessage();
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
	
	
	public String autogenera() {
	
		String codprod=null;
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement("select max(codprod)+1 from producto");
			ResultSet rs = ps.executeQuery();
			rs.next();
			codprod = rs.getLong(1)+"";
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codprod;
	}



}
