package atm;

import java.math.BigDecimal;

/***
 * 
 * @author jmercado
 * Clase que representa a una Caja de Ahorro en pesos.
 * Este tipo de cuenta permite depositar y estraer dinero en pesos. 
 * Hereda de la Clase CajaDeAhorro.
 *
 * @see CajaDeAhorro
 */

public class CajaDeAhorroPesos extends CajaDeAhorro {
	
	/***
	 * Crea una Caja de Ahorro en Pesos con los parametros que demanda
	 * la clase CajaDeAhorro.
	 * 
	 * @param alias 		el Alias de la cuenta.
	 * @param saldo 		el saldo con el que va a iniciar la cuenta.
	 * @param movimientos	los movimientos iniciales que tiene la cuenta.
	 */
	public CajaDeAhorroPesos(String alias, BigDecimal saldo) {
		
		super(alias, saldo);
	}	
}
