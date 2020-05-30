package atm;

import java.math.BigDecimal;
import java.time.LocalDate;

import exceptions.CuentaException;

public class VenderDolares extends Transaccion {

	private BigDecimal valorDolar;
	private Cuenta destino;
	
	public VenderDolares(CajaDeAhorroDolares origen, CajaDeAhorroPesos destino) {
		
		super(origen);
		this.destino = destino;
		valorDolar = new BigDecimal(70.0);
	}
	
	
	public VenderDolares(CajaDeAhorroDolares origen, CuentaCorriente destino) {
		
		super(origen);
		this.destino = destino;
		valorDolar = new BigDecimal(70.0);
	}


	@Override
	public void ajustarSaldo(BigDecimal ajuste) throws CuentaException {
	
		if( ajuste.signum() == 1 ) {

			origen.restarSaldo(ajuste);
			destino.sumarSaldo(ajuste.multiply(valorDolar));
			
			Movimiento movimiento = new Movimiento(LocalDate.now(), "Venta de dolares", origen.getAlias(), destino.getAlias(), ajuste);
			
			origen.addMovimiento(movimiento);
			destino.addMovimiento(movimiento);
		}
	}
}
