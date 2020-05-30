package atm;

import java.math.BigDecimal;
import java.time.LocalDate;

import exceptions.CuentaException;
import exceptions.ExtraccionException;

public class Extraccion extends Transaccion {

	
	public Extraccion(Cuenta origen) throws CuentaException {
		
		super(origen);
	}

	
	@Override
	public void ajustarSaldo(BigDecimal ajuste) throws CuentaException, ExtraccionException {
		
		if( ajuste.signum() == 1 ) {	
			
			origen.restarSaldo(ajuste);
			origen.addMovimiento(new Movimiento(LocalDate.now(), "Extracción", origen.getAlias(), ajuste));
 		
		}
	}
}
