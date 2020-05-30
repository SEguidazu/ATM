package atm;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

	protected BigDecimal saldo;
	protected String alias;
	protected List<Movimiento> movimientos;
	
	/***
	 * Cada Clase Concreta que extiende de Cuenta sera responsable de restar y
	 * sumar el saldo a su cuenta.
	 *
	 * @param alias Alias de la cuenta
	 * @param saldo Saldo inicial de la cuenta
	 * @param List<Movimiento> los movimientos de la cuenta
	 */
	public Cuenta(String alias, BigDecimal saldo) {
		
		this.alias = alias;
		this.saldo = saldo;
		movimientos = new ArrayList<Movimiento>();
	}

	
	/***
	 * Este metodo retorna el saldo de la cuenta
	 * 
	 * @return Saldo
	 */
	public BigDecimal getSaldo(){
		
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
	 * @return List<Movimiento> movimientos que tiene la cuenta
	 */
	public List<Movimiento> getMovimientos() {
		
		return movimientos;
	}
	
	
	/***
	 * Este metodo retorna el ultimo movimiento de la cuenta
	 * 
	 * @return Movimiento ultimo movimiento de la cuenta
	 */
	public Movimiento getLastMovimiento() {
		
		return movimientos.get(movimientos.size() - 1);
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
	public abstract void sumarSaldo(BigDecimal monto);
	
	
	/***
	 * Cada Clase Concreta que extiende de Cuenta sera responsable de restar el
	 * saldo a su cuenta.
	 * 
	 * @param 	Monto 				monto a restar a la cuenta
	 * @throws  ExcepcionCuenta 	Se lanza si puede puede extraer dinero de la cuenta
	 * 
	 * @see 	ExcepcionCuenta
	 */
	public abstract void restarSaldo(BigDecimal monto) throws CuentaException;
}
