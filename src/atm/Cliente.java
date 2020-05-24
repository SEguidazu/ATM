package atm;

import java.util.ArrayList;
import java.util.List;


public class Cliente {
	
	private String CUIT, alias;
	private List<Cuenta> cuentas;
	
	
	public Cliente(String alias, String CUIT) {
		
		cuentas = new ArrayList<Cuenta>();
		this.alias = alias;
		this.CUIT = CUIT;
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
}
