package atm;

import exceptions.PINException;

public class Tarjeta {

	private String numeroDeTarjeta;
	private Integer PIN;
	
	
	public Tarjeta(String numeroDeTarjeta, Integer PIN) {
		
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.PIN = PIN;
	}
	
	
	public String getNumeroDeTarjeta() {
		
		return numeroDeTarjeta;
	}	
	
	
	public void validarTarjeta(int PIN) throws PINException {
		
		if(PIN != this.PIN){
			throw new PINException("El numero de PIN ingresado es incorrecto.");
		}
	}
}