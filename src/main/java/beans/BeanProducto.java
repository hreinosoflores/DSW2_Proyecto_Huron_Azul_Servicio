package beans;

import java.io.Serializable;

public class BeanProducto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String CODPROD;
	private String DESCPROD;
	private String PREPROD;
	private String STKPROD;
	private String FOTOPROD;
	private String CATPROD;


	public String getCODPROD() {
		return CODPROD;
	}

	public void setCODPROD(String cODPROD) {
		CODPROD = cODPROD;
	}

	public String getDESCPROD() {
		return DESCPROD;
	}

	public void setDESCPROD(String dESCPROD) {
		DESCPROD = dESCPROD;
	}

	public String getPREPROD() {
		return PREPROD;
	}

	public void setPREPROD(String pREPROD) {
		PREPROD = pREPROD;
	}

	public String getSTKPROD() {
		return STKPROD;
	}

	public void setSTKPROD(String sTKPROD) {
		STKPROD = sTKPROD;
	}

	public String getFOTOPROD() {
		return FOTOPROD;
	}

	public void setFOTOPROD(String fOTOPROD) {
		FOTOPROD = fOTOPROD;
	}

	public String getCATPROD() {
		return CATPROD;
	}

	public void setCATPROD(String cATPROD) {
		CATPROD = cATPROD;
	}


	public BeanProducto(String dESCPROD, String pREPROD, String sTKPROD, String fOTOPROD, String cATPROD) {
		DESCPROD = dESCPROD;
		PREPROD = pREPROD;
		STKPROD = sTKPROD;
		FOTOPROD = fOTOPROD;
		CATPROD = cATPROD;
	}

	public BeanProducto() {
	}

	public BeanProducto(String cODPROD, String dESCPROD, String pREPROD, String sTKPROD, String fOTOPROD,
			String cATPROD) {
		CODPROD = cODPROD;
		DESCPROD = dESCPROD;
		PREPROD = pREPROD;
		STKPROD = sTKPROD;
		FOTOPROD = fOTOPROD;
		CATPROD = cATPROD;
	}

	@Override
	public String toString() {
		return "BeanProducto [CODPROD=" + CODPROD + ", DESCPROD=" + DESCPROD + ", PREPROD=" + PREPROD + ", STKPROD="
				+ STKPROD + ", FOTOPROD=" + FOTOPROD + ", CATPROD=" + CATPROD + "]";
	}

	

	
}
