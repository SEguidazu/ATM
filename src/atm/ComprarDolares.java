package atm;

import java.math.BigDecimal;
import java.time.LocalDate;

import exceptions.CuentaException;

public class ComprarDolares extends Transaccion {
	
	private BigDecimal impuesto, valorDolar;
	private Cuenta destino;

	public ComprarDolares(CajaDeAhorroPesos origen, CajaDeAhorroDolares destino) {
		
		super(origen);
		this.destino = destino;
		valorDolar = new BigDecimal(70.0);
		impuesto = new BigDecimal(0.3);
	}
	
	
	public ComprarDolares(CuentaCorriente origen, CajaDeAhorroDolares destino) {
		
		super(origen);
		this.destino = destino;
		valorDolar = new BigDecimal(70.0);
		impuesto = new BigDecimal(0.3);
	}
	

	@Override
	public void ajustarSaldo(BigDecimal ajuste) throws CuentaException {
		
		if( ajuste.signum() == 1 ) {
			
			ajuste = ajuste.add(ajuste.multiply(impuesto));
			
			origen.restarSaldo(ajuste);
			destino.sumarSaldo(ajuste.divide(valorDolar));
			
			Movimiento movimiento = new Movimiento(LocalDate.now(), "Compra de dolares", origen.getAlias(), destino.getAlias(), ajuste);
			
			origen.addMovimiento(movimiento);
			destino.addMovimiento(movimiento);
		}
	}

}
