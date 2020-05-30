package atm;

import java.math.BigDecimal;

import exceptions.CuentaException;
import exceptions.DepositoException;
import exceptions.ExtraccionException;

public abstract class Transaccion {

	protected Cuenta origen;
	
	
	public Transaccion(Cuenta origen) {
		
		this.origen = origen;
	}
	
	
	public abstract void ajustarSaldo(BigDecimal ajuste) throws CuentaException, DepositoException, ExtraccionException;
}
