package atm;

import java.util.List;

public class Cliente {
	
	private String CUIT;
	private String alias;
	private List<Cuenta> cuentas;
	
	
	public Cliente(String alias, String CUIT) {
		
		
	}
	
	
	public String getAlias() {
		
		return alias;
	}
	
	
	public String getCUIT() {
		
		return CUIT;
	}

	
	public void agregarCuenta(Cuenta cuenta) {
		
		
	}
	
	
	public List<Cuenta> obtenerCuentas() {
		
		return null;
	}
}
