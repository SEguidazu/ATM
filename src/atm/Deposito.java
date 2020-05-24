package atm;

public class Deposito extends Transaccion{

	
	public Deposito(Cuenta destino, Double saldo) {
		
		super(destino);
		ajustarSaldo(saldo);
	}

	
	@Override
	protected void ajustarSaldo(Double ajuste) {
		
		cuentaOrigen.sumarSaldo(ajuste);
	}
}
