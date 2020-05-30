package atm;

import java.math.BigDecimal;
import java.time.LocalDate;

import exceptions.DepositoException;

public class Deposito extends Transaccion{

	
	public Deposito(Cuenta destino) {
		
		super(destino);
	}

	
	@Override
	public void ajustarSaldo(BigDecimal ajuste) throws DepositoException {
		
		if( ajuste.signum() == 1 ) {	
			
			origen.sumarSaldo(ajuste);
			origen.addMovimiento(new Movimiento(LocalDate.now(), "Deposito", origen.getAlias(), ajuste));
 		
		}
	}
}
