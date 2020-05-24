package atm;

import exceptions.CuentaException;

public class Extraccion extends Transaccion {

	
	public Extraccion(Cuenta origen, Double saldo) throws CuentaException {
		
		super(origen);
		ajustarSaldo(saldo);
	}

	
	@Override
	protected void ajustarSaldo(Double ajuste) throws CuentaException {
		
		cuentaOrigen.restarSaldo(ajuste);
	}
}
