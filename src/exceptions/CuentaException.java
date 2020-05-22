package exceptions;

public class CuentaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5427566539042018479L;
	
	String causa;
	
	public CuentaException(String causa) {
		this.causa = causa;
	}
	
	@Override
	public String toString() {
		return causa;
	}
}
