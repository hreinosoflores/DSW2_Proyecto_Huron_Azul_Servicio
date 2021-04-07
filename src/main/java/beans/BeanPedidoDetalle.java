package beans;

import java.io.Serializable;

public class BeanPedidoDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CODPEDIDO    ;
	private String PRODUCTO     ;
	private String CANTIDAD     ;
	private String MONTO        ;
	public String getCODPEDIDO() {
		return CODPEDIDO;
	}
	public void setCODPEDIDO(String cODPEDIDO) {
		CODPEDIDO = cODPEDIDO;
	}
	public String getPRODUCTO() {
		return PRODUCTO;
	}
	public void setPRODUCTO(String pRODUCTO) {
		PRODUCTO = pRODUCTO;
	}
	public String getCANTIDAD() {
		return CANTIDAD;
	}
	public void setCANTIDAD(String cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
	public String getMONTO() {
		return MONTO;
	}
	public void setMONTO(String mONTO) {
		MONTO = mONTO;
	}
	
	
	
	public BeanPedidoDetalle() {
	}
	public BeanPedidoDetalle(String cODPEDIDO, String pRODUCTO, String cANTIDAD, String mONTO) {
		CODPEDIDO = cODPEDIDO;
		PRODUCTO = pRODUCTO;
		CANTIDAD = cANTIDAD;
		MONTO = mONTO;
	}
	@Override
	public String toString() {
		return "BeanPedidoDetalle [CODPEDIDO=" + CODPEDIDO + ", PRODUCTO=" + PRODUCTO + ", CANTIDAD=" + CANTIDAD
				+ ", MONTO=" + MONTO + "]";
	}

	
	
}
