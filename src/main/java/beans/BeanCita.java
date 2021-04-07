package beans;

import java.io.Serializable;

public class BeanCita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CODCITA         ;
	private String CLIENTE         ;
	private String SEDE            ;
	private String FECHA_HORA      ;
	private String ESTADO          ;
	private String LUGARATENCION   ;
	public String getCODCITA() {
		return CODCITA;
	}
	public void setCODCITA(String cODCITA) {
		CODCITA = cODCITA;
	}
	public String getCLIENTE() {
		return CLIENTE;
	}
	public void setCLIENTE(String cLIENTE) {
		CLIENTE = cLIENTE;
	}
	public String getSEDE() {
		return SEDE;
	}
	public void setSEDE(String sEDE) {
		SEDE = sEDE;
	}
	public String getFECHA_HORA() {
		return FECHA_HORA;
	}
	public void setFECHA_HORA(String fECHA_HORA) {
		FECHA_HORA = fECHA_HORA;
	}
	public String getESTADO() {
		return ESTADO;
	}
	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	public String getLUGARATENCION() {
		return LUGARATENCION;
	}
	public void setLUGARATENCION(String lUGARATENCION) {
		LUGARATENCION = lUGARATENCION;
	}
	
	
	
	public BeanCita() {
	}
	public BeanCita(String cLIENTE, String sEDE, String fECHA_HORA, String lUGARATENCION) {
		CLIENTE = cLIENTE;
		SEDE = sEDE;
		FECHA_HORA = fECHA_HORA;
		LUGARATENCION = lUGARATENCION;
	}

	
	
}
