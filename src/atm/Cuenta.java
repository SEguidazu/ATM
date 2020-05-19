package atm;

import java.util.List;

public abstract class Cuenta {

	private Double saldo;
	private String alias;
	private List<Movimiento> movimientos;
	
	
	public Cuenta(String alias, Double saldo) {
		
		
	}

	
	public String getAlias() {
		
		return alias;
	}
	
	
	public Double getSaldo() {
		
		return saldo;
	}
	
	
	public void agregarMovimiento() {
		
		
	}
	
	
	public List<Movimiento> obtenerMovimientos(int cantidadDeMovimientos) {
		
		return null;
	}
	
	
	public abstract void sumarSaldo();
	
	public abstract void restarSaldo();
}
