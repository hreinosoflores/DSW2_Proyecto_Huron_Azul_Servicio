package beans;

import java.io.Serializable;


public class BeanUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String CODUSUARIO;
	private String NOMUSUARIO;
	private String APEUSUARIO;
	private String DIRECCION;
	private String DNI;
	private String SEXO;
	private String FECNAC;
	private String EMAIL;
	private String TELEFONO;
	private String IDLOGIN;
	private String PASSWORD;
	private String TIPOUSUARIO;
	private String ESTADO;
	public String getCODUSUARIO() {
		return CODUSUARIO;
	}
	public void setCODUSUARIO(String cODUSUARIO) {
		CODUSUARIO = cODUSUARIO;
	}
	public String getNOMUSUARIO() {
		return NOMUSUARIO;
	}
	public void setNOMUSUARIO(String nOMUSUARIO) {
		NOMUSUARIO = nOMUSUARIO;
	}
	public String getAPEUSUARIO() {
		return APEUSUARIO;
	}
	public void setAPEUSUARIO(String aPEUSUARIO) {
		APEUSUARIO = aPEUSUARIO;
	}
	public String getDIRECCION() {
		return DIRECCION;
	}
	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getSEXO() {
		return SEXO;
	}
	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}
	public String getFECNAC() {
		return FECNAC;
	}
	public void setFECNAC(String fECNAC) {
		FECNAC = fECNAC;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public String getIDLOGIN() {
		return IDLOGIN;
	}
	public void setIDLOGIN(String iDLOGIN) {
		IDLOGIN = iDLOGIN;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getTIPOUSUARIO() {
		return TIPOUSUARIO;
	}
	public void setTIPOUSUARIO(String tIPOUSUARIO) {
		TIPOUSUARIO = tIPOUSUARIO;
	}
	public String getESTADO() {
		return ESTADO;
	}
	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	public BeanUsuario() {
	}
	public BeanUsuario(String nOMUSUARIO, String aPEUSUARIO, String dIRECCION, String dNI, String sEXO, String fECNAC,
			String eMAIL, String tELEFONO, String iDLOGIN, String pASSWORD) {
		NOMUSUARIO = nOMUSUARIO;
		APEUSUARIO = aPEUSUARIO;
		DIRECCION = dIRECCION;
		DNI = dNI;
		SEXO = sEXO;
		FECNAC = fECNAC;
		EMAIL = eMAIL;
		TELEFONO = tELEFONO;
		IDLOGIN = iDLOGIN;
		PASSWORD = pASSWORD;
	}
	public BeanUsuario(String cODUSUARIO, String dIRECCION, String eMAIL, String tELEFONO, String iDLOGIN,
			String pASSWORD) {
		CODUSUARIO = cODUSUARIO;
		DIRECCION = dIRECCION;
		EMAIL = eMAIL;
		TELEFONO = tELEFONO;
		IDLOGIN = iDLOGIN;
		PASSWORD = pASSWORD;
	}
	@Override
	public String toString() {
		return "BeanUsuario [CODUSUARIO=" + CODUSUARIO + ", NOMUSUARIO=" + NOMUSUARIO + ", APEUSUARIO=" + APEUSUARIO
				+ ", DIRECCION=" + DIRECCION + ", DNI=" + DNI + ", SEXO=" + SEXO + ", FECNAC=" + FECNAC + ", EMAIL="
				+ EMAIL + ", TELEFONO=" + TELEFONO + ", IDLOGIN=" + IDLOGIN + ", PASSWORD=" + PASSWORD
				+ ", TIPOUSUARIO=" + TIPOUSUARIO + ", ESTADO=" + ESTADO + "]";
	}
	
	

	


}
