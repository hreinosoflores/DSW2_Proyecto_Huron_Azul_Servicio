package beans;

import java.io.Serializable;

public class BeanPedidoTuneado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CODPEDIDO     ;
	private String CODUSUARIO    ;
	private String CLIENTE       ;
	private String DNI           ;
	private String DOMICILIO     ;
	private String CORREO        ;
	private String TELEFONO      ;
	private String FECHA         ;
	private String HORA          ;
	private String REFSEDE       ;
	private String METODOENVIO   ;
	private String METODOPAGO    ;
	private String MONTO         ;
	public String getCODPEDIDO() {
		return CODPEDIDO;
	}
	public void setCODPEDIDO(String cODPEDIDO) {
		CODPEDIDO = cODPEDIDO;
	}
	public String getCODUSUARIO() {
		return CODUSUARIO;
	}
	public void setCODUSUARIO(String cODUSUARIO) {
		CODUSUARIO = cODUSUARIO;
	}
	public String getCLIENTE() {
		return CLIENTE;
	}
	public void setCLIENTE(String cLIENTE) {
		CLIENTE = cLIENTE;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getDOMICILIO() {
		return DOMICILIO;
	}
	public void setDOMICILIO(String dOMICILIO) {
		DOMICILIO = dOMICILIO;
	}
	public String getCORREO() {
		return CORREO;
	}
	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}
	public String getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	public String getHORA() {
		return HORA;
	}
	public void setHORA(String hORA) {
		HORA = hORA;
	}
	public String getREFSEDE() {
		return REFSEDE;
	}
	public void setREFSEDE(String rEFSEDE) {
		REFSEDE = rEFSEDE;
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
	@Override
	public String toString() {
		return "BeanPedidoTuneado [CODPEDIDO=" + CODPEDIDO + ", CODUSUARIO=" + CODUSUARIO + ", CLIENTE=" + CLIENTE
				+ ", DNI=" + DNI + ", DOMICILIO=" + DOMICILIO + ", CORREO=" + CORREO + ", TELEFONO=" + TELEFONO
				+ ", FECHA=" + FECHA + ", HORA=" + HORA + ", REFSEDE=" + REFSEDE + ", METODOENVIO=" + METODOENVIO
				+ ", METODOPAGO=" + METODOPAGO + ", MONTO=" + MONTO + "]";
	}
	
	
	
	
}
