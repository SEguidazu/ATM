package atm;

import java.util.Stack;

import exceptions.CuentaException;

/***
 * 
 * @author jmercado
 * Clase Abstracta para manipular las Cuentas
 * Implementa la Clase Comparable para poder compararse con otras cuentas 
 * 
 * @see Comparable
 * 
 */

public abstract class Cuenta implements Comparable<Cuenta> {

	protected Double saldo;
	protected String alias;
	protected Stack<Movimiento> movimientos;
	
	/***
	 * Cada Clase Concreta que extiende de Cuenta sera responsable de restar y
	 * sumar el saldo a su cuenta.
	 *
	 * @param alias Alias de la cuenta
	 * @param saldo Saldo inicial de la cuenta
	 * @param Stack<Movimiento> los movimientos de la cuenta
	 */
	public Cuenta(String alias, Double saldo, Stack<Movimiento> movimientos) {
		
		this.alias = alias;
		this.saldo = saldo;
		this.movimientos = movimientos;
	}

	
	/***
	 * Este metodo retorna el saldo de la cuenta
	 * 
	 * @return Saldo
	 */
	public double getSaldo(){
		
		return saldo;
	}
	
	
	/***
	 * Este metodo retorna el alias de la cuenta
	 * 
	 * @return Alias	el alias de la cuenta.
	 */
	public String getAlias() {
		
		return alias;
	}
	
	
	/***
	 * Este metodo retorna los movientos de la cuenta
	 * 
	 * @return Stack<Movimiento> movimientos que tiene la cuenta
	 */
	public Stack<Movimiento> obtenerMovimientos() {
		
		return movimientos;
	}
	
	
	/***
	 * Este metodo agrega movimientos a la cuenta
	 * 
	 * @param Movimiento	movimiento de la cuenta a agregar
	 */
	public void addMovimiento(Movimiento movimiento) {
		
		movimientos.add(movimiento);
	}
	
	
	/***
	 * Las Cuentas se comparan por el Alias.
	 * 
	 * @param Cuenta	cuenta con la que se va a comparar
	 */
	@Override
	public int compareTo(Cuenta otraCuenta) {
		
		return this.alias.compareTo(otraCuenta.getAlias());
	}
	
	
	/***
	 * Cada Clase Concreta que extiende de Cuenta sera responsable de sumar el
	 * saldo a su cuenta.
	 * 
	 * @param 	Monto	monto a gregar a la cuenta
	 */
	public abstract void sumarSaldo(double monto);
	
	
	/***
	 * Cada Clase Concreta que extiende de Cuenta sera responsable de restar el
	 * saldo a su cuenta.
	 * 
	 * @param 	Monto 				monto a restar a la cuenta
	 * @throws  ExcepcionCuenta 	Se lanza si puede puede extraer dinero de la cuenta
	 * 
	 * @see 	ExcepcionCuenta
	 */
	public abstract void restarSaldo(double monto) throws CuentaException;
}
