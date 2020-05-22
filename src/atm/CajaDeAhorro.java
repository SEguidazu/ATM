package atm;

import java.util.Stack;

import exceptions.CajaAhorroException;

/***
 * 
 * @author jmercado
 * Clase que representa a una Caja de Ahorro.
 * Este tipo de cuenta permite depositar y extraer dinero. 
 * Hereda de la Clase Cuenta.
 *
 * @see Cuenta
 */

public abstract class CajaDeAhorro extends Cuenta{
	
	/***
	 * Crea una Caja de Ahorro con los parametros que demanda
	 * la clase Cuenta.
	 * 
	 * @param alias 		el Alias de la cuenta.
	 * @param saldo 		el saldo con el que va a iniciar la cuenta.
	 * @param movimientos	los movimientos iniciales que tiene la cuenta.
	 */
	public CajaDeAhorro(String alias, Double saldo, Stack<Movimiento> movimientos) {
		
		super(alias, saldo, movimientos);
	}
	
	
	/***
	 * Implementación del método abstracto de la clase cuenta que permite
	 * sumar saldo a la cuenta.
	 * 
	 * @param monto Monto a sumar al saldo de la cuenta
	 */
	@Override
	public void sumarSaldo(double monto) {
		
		saldo += monto;
	}
	
	
	/***
	 * Implementación del método abstracto de la clase cuenta que permite
	 * restar saldo a la cuenta.
	 * 
	 * @param 	monto 				Monto a estraer de la cuenta siempre y cuadno no exceda el descubierto
	 * @throws	ExcepcionCajaAhorro	Se lanza si no se puede extraer dinero de la cuenta
	 *
	 * @see 	ExcepcionCajaAhorro
	 */
	@Override
	public void restarSaldo(double monto) throws CajaAhorroException {
		
		double saldoDescontado = this.saldo - monto;
		
		if(!(saldoDescontado < 0) ) {
			
			this.saldo = saldoDescontado;
		} else {
			
			throw new CajaAhorroException("El saldo a extraer es mayor al saldo de la Caja de Ahorro.");
		}
	}

}
