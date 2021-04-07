package dao;

import java.sql.*;
import beans.*;
import sql.ConectaDB;
import java.util.*;

public class PedidoDAO {

	private ConectaDB sql = new ConectaDB();

	public String registrar(BeanPedido p, BeanPedidoDetalle[] lista_detalle) {

		String result = null;
		Connection cn = sql.getConexion();
		CallableStatement stm1 = null, stm3 = null;
		PreparedStatement stm2 = null;
		ResultSet rs = null;

		try {
			// anular el auto envio
			cn.setAutoCommit(false);

			// se crea la cabecera
			stm1 = cn.prepareCall("call SP_REGISTRAR_PEDIDO_CABECERA (?,?,?,?,?,?)");
			stm1.setLong(1, Long.parseLong(p.getCLIENTE()));
			stm1.setTimestamp(2, Timestamp.valueOf(p.getFECPEDIDO()));
			stm1.setLong(3, Long.parseLong(p.getSEDE()));
			stm1.setInt(4, Integer.parseInt(p.getMETODOENVIO()));
			stm1.setInt(5, Integer.parseInt(p.getMETODOPAGO()));
			stm1.setDouble(6, Double.parseDouble(p.getMONTO()));
			stm1.executeUpdate();

			// se obtiene el Codigo de pedido insertado
			stm2 = cn.prepareStatement("select max(codpedido) from pedido");
			rs = stm2.executeQuery();
			rs.next();
			Long nroped = rs.getLong(1);

			// se inserta el detalle de la boleta
			for (BeanPedidoDetalle pd : lista_detalle) {
				stm3 = cn.prepareCall("call SP_REGISTRAR_PEDIDO_DETALLE (?,?,?,?)");
				stm3.setLong(1, nroped);
				stm3.setLong(2, Long.parseLong(pd.getPRODUCTO()));
				stm3.setInt(3, Integer.parseInt(pd.getCANTIDAD()));
				stm3.setDouble(4, Double.parseDouble(pd.getMONTO()));
				stm3.executeUpdate();
			}

			// se ejecuta todos los SQL en la base de datos

			cn.commit();

			result = "El pedido se registró correctamente con el Nro de orden " + nroped;

		} catch (Exception e) {
			try {
				result = "Hubo un error al registrar: " + e.getMessage();
				e.printStackTrace();
				cn.rollback();
			} catch (Exception e2) {
				result = "Hubo un error: " + e2.getMessage();
				e2.printStackTrace();
			}

		} finally {
			try {
				stm3.close();
				rs.close();
				stm2.close();
				stm1.close();
				cn.close();
			} catch (Exception e2) {
				result = "Hubo un error: " + e2.getMessage();
				e2.printStackTrace();
			}
		}

		return result;
	}

	public BeanPedidoTuneado[] listar(String usuario) {
		List<BeanPedidoTuneado> temp = new ArrayList<BeanPedidoTuneado>();
		String query;
		if (usuario == null) {
			// listar todo
			query = "select * from vw_pedido_tuneado";
		} else {
			// lista por usuario
			query = "select * from vw_pedido_tuneado where CODUSUARIO=" + usuario;
		}
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BeanPedidoTuneado p = new BeanPedidoTuneado();
				p.setCODPEDIDO(rs.getLong(1) + "");
				p.setCODUSUARIO(rs.getLong(2) + "");
				p.setCLIENTE(rs.getString(3));
				p.setDNI(rs.getString(4));
				p.setDOMICILIO(rs.getString(5));
				p.setCORREO(rs.getString(6));
				p.setTELEFONO(rs.getString(7));
				p.setFECHA(rs.getString(8));
				p.setHORA(rs.getString(9));
				p.setREFSEDE(rs.getString(10));
				p.setMETODOENVIO(rs.getString(11));
				p.setMETODOPAGO(rs.getString(12));
				p.setMONTO(rs.getDouble(13) + "");
				temp.add(p);
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp.toArray(new BeanPedidoTuneado[] {});
	}

	public BeanPedidoTuneado detalle(String codpedido) {
		BeanPedidoTuneado reg = new BeanPedidoTuneado();
		Connection cn = sql.getConexion();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from vw_pedido_tuneado where CODPEDIDO=?");
			ps.setLong(1, Long.parseLong(codpedido));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				reg.setCODPEDIDO(rs.getLong(1) + "");
				reg.setCODUSUARIO(rs.getLong(2) + "");
				reg.setCLIENTE(rs.getString(3));
				reg.setDNI(rs.getString(4));
				reg.setDOMICILIO(rs.getString(5));
				reg.setCORREO(rs.getString(6));
				reg.setTELEFONO(rs.getString(7));
				reg.setFECHA(rs.getString(8));
				reg.setHORA(rs.getString(9));
				reg.setREFSEDE(rs.getString(10));
				reg.setMETODOENVIO(rs.getString(11));
				reg.setMETODOPAGO(rs.getString(12));
				reg.setMONTO(rs.getDouble(13) + "");

			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reg;

	}

}
