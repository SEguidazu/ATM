package atm;

import java.math.BigDecimal;

/***
 * 
 * @author jmercado
 * Clase que representa a una Caja de Ahorro en dolares.
 * Este tipo de cuenta permite depositar y estraer dinero en pesos. 
 * Hereda de la Clase CajaDeAhorro.
 *
 * @see CajaDeAhorro
 */

public class CajaDeAhorroDolares extends CajaDeAhorro {
	
	/***
	 * Crea una Caja de Ahorro en Dolares con los parametros que demanda
	 * la clase CajaDeAhorro.
	 * 
	 * @param alias 		el Alias de la cuenta.
	 * @param saldo 		el saldo con el que va a iniciar la cuenta.
	 * @param movimientos	los movimientos iniciales que tiene la cuenta.
	 */
	public CajaDeAhorroDolares(String alias, BigDecimal saldo) {
		
		super(alias, saldo);
	}

}
