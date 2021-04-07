package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCita;
import beans.BeanCitaTuneado;
import sql.ConectaDB;

public class CitaDAO {
	
	private ConectaDB sql=new ConectaDB();

	public String registrar(BeanCita c) {
		String result = null;
		Connection cn = sql.getConexion();
		try {
			CallableStatement cs = cn.prepareCall("{call SP_REGISTRAR_CITA(?,?,?,?)}");
			cs.setLong(1, Long.parseLong(c.getCLIENTE()));
			cs.setLong(2, Long.parseLong(c.getSEDE()));
			cs.setTimestamp(3, Timestamp.valueOf(c.getFECHA_HORA()));
			cs.setInt(4, Integer.parseInt(c.getLUGARATENCION()));
			cs.executeUpdate();
			result = "Se registró correctamente la cita";
			
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
	
	
	
	public BeanCitaTuneado[] listar(String usuario){
		List<BeanCitaTuneado> temp = new ArrayList<BeanCitaTuneado>();
		String query;
		if (usuario==null) {
			//listar todo
			query="select * from vw_cita_tuneado";
		} else {
			//lista por usuario
			query="select * from vw_cita_tuneado where CODUSUARIO=" + usuario;
		}
		
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BeanCitaTuneado c = new BeanCitaTuneado();
				c.setNRO_CITA(rs.getLong(1) + ""); 
				c.setCODUSUARIO(rs.getLong(2) + ""); 
				c.setNOM_CLIENTE(rs.getString(3)); 
				c.setDNI(rs.getString(4)); 
				c.setDOMICILIO(rs.getString(5)); 
				c.setCORREO(rs.getString(6)); 
				c.setTELEFONO(rs.getString(7)); 
				c.setSEDE(rs.getString(8)); 
				c.setFECHA(rs.getString(9)); 
				c.setHORA(rs.getString(10)); 
				c.setESTADO_ACTUAL(rs.getString(11)); 
				c.setLUGAR_ATENCION(rs.getString(12)); 
				temp.add(c);
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp.toArray(new BeanCitaTuneado[] {});
	}

	public BeanCitaTuneado detalle(String nrocita) {
		BeanCitaTuneado reg = new BeanCitaTuneado();
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from vw_cita_tuneado where NRO_CITA=?");
			ps.setLong(1, Long.parseLong(nrocita));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				reg.setNRO_CITA(rs.getLong(1) + ""); 
				reg.setCODUSUARIO(rs.getLong(2) + ""); 
				reg.setNOM_CLIENTE(rs.getString(3)); 
				reg.setDNI(rs.getString(4)); 
				reg.setDOMICILIO(rs.getString(5)); 
				reg.setCORREO(rs.getString(6)); 
				reg.setTELEFONO(rs.getString(7)); 
				reg.setSEDE(rs.getString(8)); 
				reg.setFECHA(rs.getString(9)); 
				reg.setHORA(rs.getString(10)); 
				reg.setESTADO_ACTUAL(rs.getString(11)); 
				reg.setLUGAR_ATENCION(rs.getString(12)); 
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reg;
		
	}

	
	public String cancelar(String nrocita) {
		String result = null;
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement("update CITA set ESTADO= 3 where CODCITA=?");
			ps.setLong(1, Long.parseLong(nrocita));

			ps.executeUpdate();
			result = "Se canceló la cita correctamente.";
			
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
}
