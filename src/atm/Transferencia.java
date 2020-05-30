package atm;

import java.math.BigDecimal;
import java.time.LocalDate;

import exceptions.CuentaException;


public class Transferencia extends Transaccion implements Reversible {
	
	private Cuenta destino;
	

	public Transferencia(Cuenta origen, Cuenta destino) {
		
		super(origen);
		this.destino = destino;
	}

	@Override
	public void ajustarSaldo(BigDecimal ajuste) throws CuentaException {

		if( ajuste.signum() == 1 ) {
			
			origen.restarSaldo(ajuste);
			destino.sumarSaldo(ajuste);
						
			Movimiento movimiento = new Movimiento(LocalDate.now(), "Transferencia", origen.getAlias(), destino.getAlias(), ajuste);
			
			origen.addMovimiento(movimiento);
			destino.addMovimiento(movimiento);
		}
	}

	@Override
	public void revertir() throws CuentaException {
		
		Movimiento ultimoMovimiento = origen.getLastMovimiento();

		if( ultimoMovimiento.getConcepto().equals("Transferencia") || ultimoMovimiento.getConcepto().equals("Transferencia revertida") ) {
			
			BigDecimal importe = ultimoMovimiento.getImporte();
			
			destino.restarSaldo(importe);
			origen.sumarSaldo(importe);
			
			Movimiento movimiento = new Movimiento(LocalDate.now(), "Transferencia revertida", destino.getAlias(), origen.getAlias(), importe);
			
			destino.addMovimiento(movimiento);
			origen.addMovimiento(movimiento);
		}		
	}

}
