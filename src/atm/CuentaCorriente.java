package atm;

import java.math.BigDecimal;

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
	
	private BigDecimal descubierto;
	private BigDecimal descubiertoInicial;
	
	/***
	 * Crea una Cuenta Corriente con los parametros que demanda
	 * la clase Cuenta mas el descubierto.
	 * 
	 * @param alias 		el Alias de la cuenta
	 * @param saldo 		el saldo con el que va a iniciar la cuenta
	 * @param movimientos	los movimientos iniciales que tiene la cuenta
	 * @param descubierto 	el valor del descubierto con signo positovo
	 */
	
	public CuentaCorriente(String alias, BigDecimal saldo, BigDecimal descubierto) {
	
		super(alias, saldo);
		this.descubierto = descubierto.negate();
		this.descubiertoInicial = descubierto.negate();
	}
	
	
	/***
	 * Implementación del método abstracto de la clase cuenta que permite
	 * sumar saldo a la cuenta.
	 * 
	 * @param monto Monto a sumar al saldo de la cuenta
	 */
	@Override
	public void sumarSaldo(BigDecimal monto) {
		
		if( descubierto.compareTo(descubiertoInicial) == 0 ) {
			
			saldo = saldo.add(monto);
			
		} else {
			
			BigDecimal diferencia = descubiertoInicial.subtract(descubierto);
			descubierto = descubierto.add(diferencia);
			monto = monto.subtract(diferencia);
			saldo = saldo.add(monto);
		}
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
	public void restarSaldo(BigDecimal monto) throws CuentaCorrienteException {
		
		if( saldo.compareTo(monto) >= 0 ) {
			
			saldo = saldo.subtract(monto);
			
		} else if( descubierto.compareTo(monto) >= 0 ) {	
			
			monto = monto.subtract(saldo);
			saldo = new BigDecimal(0);
			descubierto = descubierto.subtract(monto);
			
		} else {
			
			throw new CuentaCorrienteException("El monto a extraer excede el descubierto de su cuenta.");
		}
	}

}
