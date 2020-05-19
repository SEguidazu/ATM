package atm;

public class Tarjeta {

	private String numeroDeTarjeta;
	private Integer PIN;
	private String CUIT;
	
	
	public Tarjeta(String numeroDeTarjeta, int PIN, String CUIT) {
		
		
	}
	
	
	public String getNumeroDeTarjeta() {
		
		return numeroDeTarjeta;
	}
	
	
	public String getCUIT() {
		
		return CUIT;
	}
	
	
	public void validarTarjeta(int PIN) {
		
	}
}
