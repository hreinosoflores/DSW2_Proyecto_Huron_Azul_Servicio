package beans;

import java.io.Serializable;

public class BeanPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String CODPEDIDO       ;
	private String CLIENTE         ;
	private String FECPEDIDO       ;
	private String SEDE      ;
	private String METODOENVIO     ;
	private String METODOPAGO      ;
	private String MONTO           ;
	public String getCODPEDIDO() {
		return CODPEDIDO;
	}
	public void setCODPEDIDO(String cODPEDIDO) {
		CODPEDIDO = cODPEDIDO;
	}
	public String getCLIENTE() {
		return CLIENTE;
	}
	public void setCLIENTE(String cLIENTE) {
		CLIENTE = cLIENTE;
	}
	public String getFECPEDIDO() {
		return FECPEDIDO;
	}
	public void setFECPEDIDO(String fECPEDIDO) {
		FECPEDIDO = fECPEDIDO;
	}
	public String getSEDE() {
		return SEDE;
	}
	public void setSEDE(String sEDE) {
		SEDE = sEDE;
	}
	public String getMETODOENVIO() {
		return METODOENVIO;
	}
	public void setMETODOENVIO(String mETODOENVIO) {
		METODOENVIO = mETODOENVIO;
	}
	public String getMETODOPAGO() {
		return METODOPAGO;
	}
	public void setMETODOPAGO(String mETODOPAGO) {
		METODOPAGO = mETODOPAGO;
	}
	public String getMONTO() {
		return MONTO;
	}
	public void setMONTO(String mONTO) {
		MONTO = mONTO;
	}
	public BeanPedido() {
	}
	public BeanPedido(String cLIENTE, String fECPEDIDO, String sEDE, String mETODOENVIO, String mETODOPAGO,
			String mONTO) {
		CLIENTE = cLIENTE;
		FECPEDIDO = fECPEDIDO;
		SEDE = sEDE;
		METODOENVIO = mETODOENVIO;
		METODOPAGO = mETODOPAGO;
		MONTO = mONTO;
	}
	@Override
	public String toString() {
		return "BeanPedido [CODPEDIDO=" + CODPEDIDO + ", CLIENTE=" + CLIENTE + ", FECPEDIDO=" + FECPEDIDO + ", SEDE="
				+ SEDE + ", METODOENVIO=" + METODOENVIO + ", METODOPAGO=" + METODOPAGO + ", MONTO=" + MONTO + "]";
	}
	
	
	
	
}
