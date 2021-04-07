package beans;

import java.io.Serializable;

public class BeanCategoriaProd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CODCAT    ;
	private String DESCCAT   ;
	public String getCODCAT() {
		return CODCAT;
	}
	public void setCODCAT(String cODCAT) {
		CODCAT = cODCAT;
	}
	public String getDESCCAT() {
		return DESCCAT;
	}
	public void setDESCCAT(String dESCCAT) {
		DESCCAT = dESCCAT;
	}
	@Override
	public String toString() {
		return "BeanCategoriaProd [CODCAT=" + CODCAT + ", DESCCAT=" + DESCCAT + "]";
	}
	
	

}
