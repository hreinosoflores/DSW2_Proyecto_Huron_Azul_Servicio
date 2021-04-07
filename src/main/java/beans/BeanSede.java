package beans;

import java.io.Serializable;

public class BeanSede implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CODSEDE ;
	private String REFSEDE ;
	private String DIRSEDE ;
	public String getCODSEDE() {
		return CODSEDE;
	}
	public void setCODSEDE(String cODSEDE) {
		CODSEDE = cODSEDE;
	}
	public String getREFSEDE() {
		return REFSEDE;
	}
	public void setREFSEDE(String rEFSEDE) {
		REFSEDE = rEFSEDE;
	}
	public String getDIRSEDE() {
		return DIRSEDE;
	}
	public void setDIRSEDE(String dIRSEDE) {
		DIRSEDE = dIRSEDE;
	}
	@Override
	public String toString() {
		return "BeanSede [CODSEDE=" + CODSEDE + ", REFSEDE=" + REFSEDE + ", DIRSEDE=" + DIRSEDE + "]";
	}

	
}
