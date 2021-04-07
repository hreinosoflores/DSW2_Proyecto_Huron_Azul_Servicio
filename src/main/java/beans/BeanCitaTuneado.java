package beans;

import java.io.Serializable;

public class BeanCitaTuneado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String NRO_CITA         ;
	private String CODUSUARIO;
	private String NOM_CLIENTE      ;
	private String DNI              ;
	private String DOMICILIO        ;
	private String CORREO           ;
	private String TELEFONO         ;
	private String SEDE             ;
	private String FECHA            ;
	private String HORA             ;
	private String ESTADO_ACTUAL    ;
	private String LUGAR_ATENCION   ;
	
	
	public String getNRO_CITA() {
		return NRO_CITA;
	}
	public void setNRO_CITA(String nRO_CITA) {
		NRO_CITA = nRO_CITA;
	}
	public String getCODUSUARIO() {
		return CODUSUARIO;
	}
	public void setCODUSUARIO(String cODUSUARIO) {
		CODUSUARIO = cODUSUARIO;
	}
	
	
	public String getNOM_CLIENTE() {
		return NOM_CLIENTE;
	}
	public void setNOM_CLIENTE(String nOM_CLIENTE) {
		NOM_CLIENTE = nOM_CLIENTE;
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
	public String getSEDE() {
		return SEDE;
	}
	public void setSEDE(String sEDE) {
		SEDE = sEDE;
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
	public String getESTADO_ACTUAL() {
		return ESTADO_ACTUAL;
	}
	public void setESTADO_ACTUAL(String eSTADO_ACTUAL) {
		ESTADO_ACTUAL = eSTADO_ACTUAL;
	}
	public String getLUGAR_ATENCION() {
		return LUGAR_ATENCION;
	}
	public void setLUGAR_ATENCION(String lUGAR_ATENCION) {
		LUGAR_ATENCION = lUGAR_ATENCION;
	}
	@Override
	public String toString() {
		return "BeanCitaTuneado [NRO_CITA=" + NRO_CITA + ", CODUSUARIO=" + CODUSUARIO + ", NOM_CLIENTE=" + NOM_CLIENTE
				+ ", DNI=" + DNI + ", DOMICILIO=" + DOMICILIO + ", CORREO=" + CORREO + ", TELEFONO=" + TELEFONO
				+ ", SEDE=" + SEDE + ", FECHA=" + FECHA + ", HORA=" + HORA + ", ESTADO_ACTUAL=" + ESTADO_ACTUAL
				+ ", LUGAR_ATENCION=" + LUGAR_ATENCION + "]";
	}
	
	
	
}
