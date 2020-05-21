package atm;

import java.util.ArrayList;
import java.util.List;

import exceptions.CuitErroneoException;

public class Cliente {
	
	private String CUIT;
	private String alias;
	private List<Cuenta> cuentas;
	
	
	public Cliente(String alias, String CUIT) throws CuitErroneoException {
		
		cuentas = new ArrayList<Cuenta>();
		setCUIT(CUIT);
	}
	
	
	private void setCUIT(String CUIT) throws CuitErroneoException {

		if(!sonNumeros(CUIT)) {
			
			throw new CuitErroneoException("El CUIT se compone solo de números.");
		} else if(CUIT.length() == 11) {
			
			throw new CuitErroneoException("El CUIT se compone de 11 números.");
		} else {
		
			this.CUIT = CUIT;
		}
	}


	public String getAlias() {
		
		return alias;
	}
	
	
	public String getCUIT() {
		
		return CUIT;
	}

	
	public void agregarCuenta(Cuenta cuenta) {
		
		cuentas.add(cuenta);
	}
	
	
	public List<Cuenta> obtenerCuentas() {
		
		return cuentas;
	}


	private boolean sonNumeros(String cadena){
		
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
