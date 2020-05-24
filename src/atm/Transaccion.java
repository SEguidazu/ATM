package atm;

import exceptions.CuentaException;

public abstract class Transaccion {

	protected Cuenta cuentaOrigen;
	
	
	public Transaccion(Cuenta origen) {
		
		this.cuentaOrigen = origen;
	}
	
	
	protected abstract void ajustarSaldo(Double ajuste) throws CuentaException;
}
