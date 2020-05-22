package atm;

import java.util.Stack;

import exceptions.CuentaCorrienteException;

/***
 * 
 * @author jmercado
 * Clase que representa una cuenta Corriente.
 * Este tipo de cuenta permite retirar su saldo mas un descubierto
 * Hereda de la Clase Cuenta.
 *
 * @see Cuenta
 */

public class CuentaCorriente extends Cuenta{
	
	private Double descubierto;
	
	/***
	 * Crea una Cuenta Corriente con los parametros que demanda
	 * la clase Cuenta mas el descubierto.
	 * 
	 * @param alias 		el Alias de la cuenta
	 * @param saldo 		el saldo con el que va a iniciar la cuenta
	 * @param movimientos	los movimientos iniciales que tiene la cuenta
	 * @param descubierto 	el valor del descubierto con signo positovo
	 */
	
	public CuentaCorriente(String alias, Double saldo, Stack<Movimiento> movimientos, Double descubierto) {
	
		super(alias, saldo, movimientos);
		this.descubierto = descubierto * -1;
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
	 * Implementaci�n del m�todo abstracto de la clase cuenta que permite
	 * restar saldo a la cuenta.
	 * 
	 * @param 	monto 						Monto a estraer de la cuenta siempre y cuadno no exceda el descubierto
	 * @throws	ExcepcionCuentaCorriente	Se lanza si no se puede extraer dinero de la cuenta
	 * 
	 * @see 	ExcepcionCuentaCorriente
	 */
	@Override
	public void restarSaldo(double monto) throws CuentaCorrienteException {
		
		double saldoDescontado = this.saldo - monto;
		
		if(!(saldoDescontado < descubierto) ) {
			
			this.saldo = saldoDescontado;
		} else {
			
			throw new CuentaCorrienteException("El monto a extraer excede el descubierto de su cuenta.");
		}
	}

}
